package by.levchenko;

import java.util.List;

public class ProcessedMessage {
	private String id;
	private List<String> splitStatement;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getSplitStatement() {
		return splitStatement;
	}

	public void setSplitStatement(List<String> splitStatement) {
		this.splitStatement = splitStatement;
	}

}
