package ClassDetailInfo;

public class MemberVariable extends ClassMemberAbstract{
	private String _reference, _variableType, _variableName;
	public MemberVariable() {}
	public MemberVariable(String reference, String variableType, String variableName) 
	{
		_reference = reference;
		_variableType = variableType;
		_variableName = variableName;
	}
	@Override
	public String toString(){
		StringBuilder builder=new StringBuilder();
		switch (_reference){
			case "Public":
				builder.append(" + ");
				break;
			case "Private":
				builder.append(" - ");
				break;
			case "Protected":
				builder.append(" # ");
				break;
			case "Packaged":
				builder.append(" ~ ");
				break;
			default:
				break;
		}
		builder.append(_variableName).append(" : ").append(_variableType);
		return builder.toString();
	}

	@Override
	public String getReference() {
		return _reference;
	}
	
	@Override
	public void setReference(String reference) {
		this._reference = reference;
	}
	
	@Override
	public String getType() {
		return _variableType;
	}
	
	@Override
	public void setType(String variableType) {
		this._variableType = variableType;
	}
	
	@Override
	public String getName() {
		return _variableName;
	}
	
	@Override
	public void setName(String variableName) {
		this._variableName = variableName;
	}
	
	@Override
    public void reSet()
    {
		_reference = "";
		_variableType = "";
		_variableName = "";
    }
	
}
