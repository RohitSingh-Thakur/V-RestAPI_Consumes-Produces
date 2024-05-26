package com.v.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.JsonNode;
import com.v.entity.MessageEntity;

public class SupporterClass {

	 public static String determineRequestedMediaType(HttpServletRequest request) {
	        // Get the Accept header from the request
	        String acceptHeader = request.getHeader("Accept");

	        // Check if the Accept header is not null and contains any supported media types
	        if (acceptHeader != null) {
	            if (acceptHeader.contains(MediaType.APPLICATION_XML_VALUE)) {
	                return MediaType.APPLICATION_XML_VALUE;
	            } else if (acceptHeader.contains(MediaType.APPLICATION_JSON_VALUE)) {
	                return MediaType.APPLICATION_JSON_VALUE;
	            } else if (acceptHeader.contains(MediaType.TEXT_PLAIN_VALUE)) {
	                return MediaType.TEXT_PLAIN_VALUE;
	            }
	        }

	        // If no supported media type is found in the Accept header, return a default media type
	        return MediaType.APPLICATION_JSON_VALUE;
	    }

	 public static  MessageEntity generateMessageEntity(String msg) {
	        // Generate a new MessageEntity object with some sample values
	        return new MessageEntity(RandomeNumber.getRandomeNumber(), 
	        										msg, TimeStampUtil.getTimeStamp());
	    }

	 public static String generatePlainTextData() {
	        // Generate plain text data
	        return "This is plain text data";
	    }
	  
	 public static String convertMessageEntityToPlainText(MessageEntity messageEntity) {
	        // Convert MessageEntity to plain text representation
	        return "Message ID: " + messageEntity.getMessageId() + "\n" +
	               "Message: " + messageEntity.getMessage() + "\n" +
	               "Timestamp: " + messageEntity.getTimeStamp();
	    }
	 
	 public static String getTextContent(Element element) {
	        StringBuilder textContent = new StringBuilder();

	        // Get all child nodes of the element
	        NodeList childNodes = element.getChildNodes();

	        // Iterate through child nodes
	        for (int i = 0; i < childNodes.getLength(); i++) {
	            if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
	                // If the child node is an element, recursively get its text content
	                Element childElement = (Element) childNodes.item(i);
	                textContent.append(getTextContent(childElement)).append(" ");
	            } else if (childNodes.item(i).getNodeType() == Node.TEXT_NODE) {
	                // If the child node is text, append its content to the result
	                textContent.append(childNodes.item(i).getTextContent().trim()).append(" ");
	            }
	        }

	        return textContent.toString().trim();
	    }
	 
	    public static String convertJsonToText(JsonNode node) {
	        StringBuilder textContent = new StringBuilder();

	        // Iterate over fields of the JSON object
	        for (JsonNode field : node) {
	            if (field.isObject()) {
	                // If field is an object, recursively process its fields
	                textContent.append(convertJsonToText(field)).append(" ");
	            } else if (field.isTextual()) {
	                // If field is a text node, append its value to the result
	                textContent.append(field.asText()).append(" ");
	            }
	            // Add handling for other types if needed (e.g., numeric, boolean)
	        }

	        return textContent.toString().trim();
	    }
}
