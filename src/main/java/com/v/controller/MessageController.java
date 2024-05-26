package com.v.controller;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.v.entity.MessageEntity;
import com.v.util.RandomeNumber;
import com.v.util.SupporterClass;
import com.v.util.TimeStampUtil;

@RestController
@RequestMapping(path = "/msgApi")
public class MessageController {

	
	//API consumes nothing - produces nothing
	@GetMapping(value = "/consumesNothingProducesNothing")
	public void consumesNothingProducesNothing() {
	}
	
	//API consumes nothing - produces text
	@GetMapping(value = "/consumesNothingProducesText", produces = "text/Plain")
	public String consumesNothingProducesText() {
		return "Api Consumes Nothing Produces Text...";
	}
	
	//API consumes nothing - produces json
	@GetMapping(value = "/consumesNothingProducesJson", produces = "application/json")
	public MessageEntity consumesNothingProducesJson() {
		return new MessageEntity(RandomeNumber.getRandomeNumber(), "Consumes ", TimeStampUtil.getTimeStamp());
	}
	
	//API consumes nothing - produces xml
	@GetMapping(value = "/consumesNothingProducesXml", produces = "application/xml")
	public MessageEntity consumesNothingProducesXml() {
		return new MessageEntity(RandomeNumber.getRandomeNumber(), "Consumes ", TimeStampUtil.getTimeStamp());
	}
	
	//API consumes text - produces nothing
	@PostMapping(path = "/consumesTextProducesNothing", consumes = "text/plain")
	public void consumesTextProducesNothing(@RequestBody String msg) {
	}
	
	//API consumes text - produces text
	@PostMapping(path = "/consumesTextProducesText", consumes = "text/plain", produces = "text/plain")
	public String consumesTextProducesText(@RequestBody String msg) {
		return "Your Message Is : " + msg;
	}
	
	//API consumes text - produces json
	@PostMapping(path = "/consumesTextProducesJson", consumes = "text/plain", produces = "application/json")
	public MessageEntity consumesTextProducesJson(@RequestBody String msg) {
		return new MessageEntity(RandomeNumber.getRandomeNumber(), "Your Message => : " + msg, TimeStampUtil.getTimeStamp());
	}
	
	//API consumes text - produces xml
	@PostMapping(path = "/consumesTextProducesXml", consumes = "text/plain", produces = "application/xml")
	public MessageEntity consumesTextProducesXml(@RequestBody String msg) {
		return new MessageEntity(RandomeNumber.getRandomeNumber(), "Your Message = " + msg, TimeStampUtil.getTimeStamp());
	}
	
	//API consumes json - produces nothing
	@PostMapping(path = "/consumesJsonProducesNothing", consumes = "application/json")
	public void consumesJsonProducesNothing(@RequestBody MessageEntity msg) {	
	}
	
	//API consumes json - produces a text
	@PostMapping(path = "/consumesJsonProducesText", consumes = "application/json", produces = "text/plain")
	public String consumesJsonProducesText(@RequestBody MessageEntity msg) {	
		return "Message Received...";
	}
	
	//API consumes json - produces a json
	@PostMapping(path = "/consumesJsonProducesJson", consumes = "application/json", produces = "application/json")
	public MessageEntity consumesJsonProducesJson(@RequestBody MessageEntity msg) {	
		return msg;
	}
	
	//API consumes json - produces a xml
	@PostMapping(path = "/consumesJsonProducesXml", consumes = "application/json", produces = "application/xml")
	public MessageEntity consumesJsonProducesXml(@RequestBody MessageEntity msg) {	
		return msg;
	}
	
	//API consumes xml - produces nothing
	@PostMapping(path = "/consumesXmlProducesNothing", consumes = "application/xml")
	public void consumesXmlProducesNothing(@RequestBody MessageEntity msg) {	
	}
	
	//API consumes xml - produces a text
	@PostMapping(path = "/consumesXmlProducesText", consumes = "application/xml", produces = "text/plain")
	public String consumesXmlProducesText(@RequestBody MessageEntity msg) {	
		return "Message Received...";
	}
	
	//API consumes xml - produces a json
	@PostMapping(path = "/consumesXmlProducesJson", consumes = "application/xml", produces = "application/json")
	public MessageEntity consumesXmlProducesJson(@RequestBody MessageEntity msg) {	
		return msg;
//		return new MessageEntity(RandomeNumber.getRandomeNumber(), "Your Message = " + msg, TimeStampUtil.getTimeStamp());
	}
	
	//API consumes xml - produces a xml
	@PostMapping(path = "/consumesXmlProducesXml", consumes = "application/xml", produces = "application/xml")
	public MessageEntity consumesXmlProducesXml(@RequestBody MessageEntity msg) {	
		return msg;
	}
	
	
	
	
	
	
	
	
	
	/*
	 * //API consumes xml/json/text - produces nothing
	 * 
	 * @PostMapping(path = "/consumesXml_Json_TextProducesNothing", consumes =
	 * {"application/xml", "application/json", "text/plain"}) public void
	 * consumesXml_Json_TextProducesNothing(@RequestBody String message) { if
	 * (message != null) { // Check content type and handle accordingly if
	 * (message.trim().startsWith("{") && message.trim().endsWith("}")) { // JSON
	 * data System.out.println("Received JSON data: " + message); } else if
	 * (message.trim().startsWith("<") && message.trim().endsWith(">")) { // XML
	 * data System.out.println("Received XML data: " + message); } else { // Plain
	 * text data System.out.println("Received plain text: " + message); } } else {
	 * // Handle unsupported media type throw new
	 * UnsupportedOperationException("Unsupported media type"); } }
	 */
	  
	
	
//API consumes xml/json/text - produces nothing
//==============================================
	  @PostMapping(path = "/consumesXml_Json_TextProducesNothing", consumes = {"application/xml", "application/json", "text/plain"})
	    public void consumesXml_Json_TextProducesNothing(@RequestBody String message , HttpServletRequest request) {
		  
		  String contentType = request.getContentType();

		  if (contentType != null) {	          
	            if (contentType.equals("application/json")) {
	                 System.out.println("Received JSON data: " + message);
	            } else if (contentType.equals("application/xml")) {
	                 System.out.println("Received XML data: " + message);
	            } else {
	                 System.out.println("Received plain text: " + message);
	            }
	        } else {
	              throw new UnsupportedOperationException("Unsupported media type");
	        }
	    }
	
	
	
//API consumes nothing - produces xml/json/text
//==============================================
	  @GetMapping(path = "/consumesNothingProducesXml_Json_Text", produces = {"application/xml", "application/json", "text/plain"})
	    public Object consumesNothingProducesXml_Json_Text(HttpServletRequest request) {
	      
	        String acceptHeaderValue = SupporterClass.determineRequestedMediaType(request);

	        if (MediaType.APPLICATION_XML_VALUE.equals(acceptHeaderValue)) {
	            return SupporterClass.generateMessageEntity(""); // Returns MessageEntity object for XML
	        } else if (MediaType.APPLICATION_JSON_VALUE.equals(acceptHeaderValue)) {
	            return SupporterClass.generateMessageEntity(""); // Returns MessageEntity object for JSON
	        } else if (MediaType.TEXT_PLAIN_VALUE.equals(acceptHeaderValue)) {
	           // return generatePlainTextData(); // Returns plain text
	        	return SupporterClass.convertMessageEntityToPlainText(SupporterClass.generateMessageEntity(""));
	        } else {
	            // Handle unsupported media type
	            return "Unsupported media type: " + acceptHeaderValue;
	        }
	    }

	   	  
	    
	   
	 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    @PostMapping(path = "consumesXml_Json_TextProducesXml_Json_Text",
	    		consumes = {"application/xml", "application/json", "text/plain"},
	    		produces = {"application/xml", "application/json", "text/plain"})
	    public Object consumesXml_Json_TextProducesXml_Json_Text(@RequestBody String message , HttpServletRequest request) throws JAXBException, ParserConfigurationException, SAXException, IOException {
	    	
	    	  String contentType = request.getContentType();

			  if (contentType != null) {	
				  
		            if (contentType.equals("application/json")) { // ===============================================> JSON DATA
		            	String acceptHeaderValue = SupporterClass.determineRequestedMediaType(request);

		    	        if (MediaType.APPLICATION_XML_VALUE.equals(acceptHeaderValue)) {
		    	        	ObjectMapper objectMapper = new ObjectMapper();
		    	        	MessageEntity entity = objectMapper.readValue(message, MessageEntity.class);
		    	        	JAXBContext jaxbContext = JAXBContext.newInstance(MessageEntity.class);
		    	        	Marshaller marshaller = jaxbContext.createMarshaller();
		    	        	StringWriter sw = new StringWriter();
		    	        	marshaller.marshal(entity, sw);
		    	        	String xmlString = sw.toString();
		    	            return xmlString; // xmlString contains xml representation of MessageEntity object 
		    	        } else if (MediaType.APPLICATION_JSON_VALUE.equals(acceptHeaderValue)) {
		    	        	return message;
		    	        } else if (MediaType.TEXT_PLAIN_VALUE.equals(acceptHeaderValue)) {
    	        	
		    	        	 // Parse JSON string into a JsonNode
		    	            ObjectMapper mapper = new ObjectMapper();
		    	            JsonNode rootNode = mapper.readTree(message);

		    	            // Convert JSON data to text
		    	            String textData = SupporterClass.convertJsonToText(rootNode);
		    	        	
		    	           	return textData;
		    	        } else {
		    	            // Handle unsupported media type
		    	            return "Unsupported media type: " + acceptHeaderValue;
		    	        }
		            	
		            	
		            	
		            } else if (contentType.equals("application/xml")) { // ===============================================> XML DATA
		            	String acceptHeaderValue = SupporterClass.determineRequestedMediaType(request);

		    	        if (MediaType.APPLICATION_XML_VALUE.equals(acceptHeaderValue)) {
		    	            return message;
		    	        } else if (MediaType.APPLICATION_JSON_VALUE.equals(acceptHeaderValue)) {
		    	        	 JAXBContext jaxbContext = JAXBContext.newInstance(MessageEntity.class);
		    	        	    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		    	        	    MessageEntity entity = (MessageEntity) unmarshaller.unmarshal(new StringReader(message));
		    	        	    
		    	        	    ObjectMapper objectMapper = new ObjectMapper();
		    	        	    String json = objectMapper.writeValueAsString(entity);
		    	        	return json;
		    	        } else if (MediaType.TEXT_PLAIN_VALUE.equals(acceptHeaderValue)) {
    	        	
		    	        	 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    	             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		    	             // Parse the XML string into a Document object
		    	             Document doc = dBuilder.parse(new InputSource(new StringReader(message)));

		    	             // Normalize the document (optional but recommended)
		    	             doc.getDocumentElement().normalize();

		    	             // Get the root element
		    	             Element rootElement = doc.getDocumentElement();

		    	             // Convert XML data to text
		    	             String textData = SupporterClass.getTextContent(rootElement);

		    	        	
		    	           	return textData;
		    	        } else {
		    	            // Handle unsupported media type
		    	            return "Unsupported media type: " + acceptHeaderValue;
		    	        }
		    	        
		    	        
		    	        
		            } else { // ========================================================================> TEXT DATA
		            	String acceptHeaderValue = SupporterClass.determineRequestedMediaType(request);

		    	        if (MediaType.APPLICATION_XML_VALUE.equals(acceptHeaderValue)) {
		    	            return SupporterClass.generateMessageEntity(message);
		    	        } else if (MediaType.APPLICATION_JSON_VALUE.equals(acceptHeaderValue)) {
		    	        	return SupporterClass.generateMessageEntity(message);
		    	        } else if (MediaType.TEXT_PLAIN_VALUE.equals(acceptHeaderValue)) {
		    	           	return message;
		    	        } else {
		    	            // Handle unsupported media type
		    	            return "Unsupported media type: " + acceptHeaderValue;
		    	        }
		            }
		        } else {
		              throw new UnsupportedOperationException("Unsupported media type");
		        }
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}
