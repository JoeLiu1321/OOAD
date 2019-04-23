package adapter;

import ClassDetailInfo.*;

import java.util.ArrayList;
import java.util.List;

public class ClassDetailInfoDTO {
    private ClassDetailInfo classDetailInfo;
    private List<String> methods;
    private List<String> variables;
    private String className;
    public ClassDetailInfoDTO(ClassDetailInfo classDetailInfo){
        setClassDetailInfo(classDetailInfo);
    }

    public List<String> getMethods() {
        return methods;
    }

    public List<String> getVariables() {
        return variables;
    }

    public String getClassName() {
        return className;
    }

    public void setClassDetailInfo(ClassDetailInfo classDetailInfo) {
        this.classDetailInfo = classDetailInfo;
        parseClassName(classDetailInfo);
        parseMethod(classDetailInfo);
        parseVariable(classDetailInfo);
    }

    private void parseMethod(ClassDetailInfo classDetailInfo){
        List<ClassMemberAbstract>memberMethods=classDetailInfo.getMemberFunction();
        List<String>methods=new ArrayList<>();
        for(ClassMemberAbstract c:memberMethods)
            methods.add(c.toString());
        this.methods=methods;
    }

    private void parseVariable(ClassDetailInfo classDetailInfo){
        List<ClassMemberAbstract>memberVariable=classDetailInfo.getMemberVariable();
        List<String>variables=new ArrayList<>();
        for(ClassMemberAbstract c:memberVariable)
            variables.add(c.toString());
        this.variables=variables;
    }

    private void parseClassName(ClassDetailInfo classDetailInfo){
        this.className=classDetailInfo.getClassName();
    }
}
