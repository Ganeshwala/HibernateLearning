package Com.Hibenate.OneToOneMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	@Column(name = "questionId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qId;
	private String qusteion;
	@OneToOne
	@JoinColumn(name = "a_id")
	private Answer ans;
	
	public Question() {
		
	}
	
	public Question(int qId, String qusteion) {
		super();
		this.qId = qId;
		this.qusteion = qusteion;
	}

	public Answer getAnswer() {
		return ans;
	}

	public void setAnswer(Answer answer) {
		this.ans = answer;
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQusteion() {
		return qusteion;
	}

	public void setQusteion(String qusteion) {
		this.qusteion = qusteion;
	}

	@Override
	public String toString() {
		return "Question [qId=" + qId + ", qusteion=" + qusteion + "]";
	}

}
