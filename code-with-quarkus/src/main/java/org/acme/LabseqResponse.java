package org.acme;

public class LabseqResponse{
        private String value;
        private String message;
    
        public LabseqResponse() {}
        
        public LabseqResponse(String value, String message) {
            this.value = value;
            this.message = message;
        }
    
        public String getValue() {
            return value;
        }
    
        public void setValue(String value) {
            this.value = value;
        }
    
        public String getMessage() {
            return message;
        }
    
        public void setMessage(String message) {
            this.message = message;
        }
    }