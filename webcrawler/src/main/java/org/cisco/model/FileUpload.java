package org.cisco.model;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	MultipartFile file;
	private String filename;
	private String filelocation;
	private String path;
	private String qrypath;
	private String resultpath;
	

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilelocation() {
		return filelocation;
	}

	public void setFilelocation(String filelocation) {
		this.filelocation = filelocation;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getQrypath() {
		return qrypath;
	}

	public void setQrypath(String qrypath) {
		this.qrypath = qrypath;
	}

	public String getResultpath() {
		return resultpath;
	}

	public void setResultpath(String resultpath) {
		this.resultpath = resultpath;
	}
	
	
}
