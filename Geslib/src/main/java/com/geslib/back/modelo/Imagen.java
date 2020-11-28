package com.geslib.back.modelo;


public class Imagen {

	    private String fileName;

	    private String fileType;
	    private byte[] data;

	    public Imagen(String fileName, String fileType, byte[] data) {
	        this.fileName = fileName;
	        this.fileType = fileType;
	        this.data = data;
	    }
	    public String getFileName() {
	        return fileName;
	    }

	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }

	    public String getFileType() {
	        return fileType;
	    }

	    public void setFileType(String fileType) {
	        this.fileType = fileType;
	    }

	    public byte[] getData() {
	        return data;
	    }

	    public void setData(byte[] data) {
	        this.data = data;
	    }
	}
