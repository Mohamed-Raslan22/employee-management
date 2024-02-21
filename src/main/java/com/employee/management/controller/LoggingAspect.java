package com.employee.management.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.employee.management.Excep.BeanNotFoundException;
import com.employee.management.entity.RequestResponseLog;
import com.employee.management.repository.RequestResponseLogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Aspect
@Component
public class LoggingAspect {

	@Autowired
	private RequestResponseLogRepository logRepository;

	@Before("execution(* com.employee.management.controller.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String requestId = (String) request.getAttribute("requestId");

		RequestResponseLog log = new RequestResponseLog();
		log.setRequestUrl(request.getRequestURL().toString());
		log.setHttpMethod(request.getMethod());
		log.setRequestId(requestId);
		log.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		log.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

		logRepository.save(log);
	}

	@AfterReturning(pointcut = "execution(* com.employee.management.controller.*.*(..))", returning = "result")
	public void logAfterReturning(Object result) throws BeanNotFoundException, JsonProcessingException {

			try {
				ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpServletRequest request = attributes.getRequest();
				String requestId = (String) request.getAttribute("requestId");

				RequestResponseLog log = logRepository.findByRequestId(requestId)
						.orElseThrow(() -> new BeanNotFoundException("this log does not exist :" + requestId));

				ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(result);
				String shortText = json.length() > 100 ? json.substring(0, 100) : String.format("%-20s", json);
				log.setResponse(shortText);
				logRepository.save(log);

			} catch (Exception e) {
				if (result instanceof ResponseEntity) {
					ResponseEntity<?> entity = (ResponseEntity<?>) result;
					HttpStatus status = entity.getStatusCode();
					if (status == HttpStatus.NOT_FOUND) {
						ResponseEntity<?> modifiedResponse = ResponseEntity.status(HttpStatus.NOT_FOUND).body(entity.getBody());
					}else if (status == HttpStatus.BAD_REQUEST) {
						ResponseEntity<?> modifiedResponse = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entity.getBody());
					}else {
						ResponseEntity<?> modifiedResponse = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(entity.getBody());
						
					}
			}

		}

	}
}