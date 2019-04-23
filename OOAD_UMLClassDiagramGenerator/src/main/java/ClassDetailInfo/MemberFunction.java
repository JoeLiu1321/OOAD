package ClassDetailInfo;

public class MemberFunction extends ClassMemberAbstract{
	private String _reference, _functuonType, _functuonName;
	public MemberFunction() {}
	public MemberFunction(String reference, String functuonType, String functuonName) 
	{
		_reference = reference;
		_functuonType = functuonType;
		_functuonName = functuonName;
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
			case "Package":
				builder.append(" ~ ");
			default:
				break;
		}
		builder.append(_functuonName).append("()").append(" : ").append(_functuonType);
		return builder.toString();
	}

	@Override
	public String getType() {
		return _functuonType;
	}
	
	@Override
	public void setType(String _functuonType) {
		this._functuonType = _functuonType;
	}
	
	@Override
	public String getReference() {
		return _reference;
	}
	
	@Override
	public void setReference(String _reference) {
		this._reference = _reference;
	}
	
	@Override
	public String getName() {
		return _functuonName;
	}
	
	@Override
	public void setName(String _functuonName) {
		this._functuonName = _functuonName;
	}
	
	@Override
    public void reSet()
    {
		_reference = "";
		_functuonType = "";
		_functuonName = "";
    }

}
