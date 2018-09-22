package depends.deptypes;

import java.util.ArrayList;

public class DependencyType {
	
    // struct->method
    public static final String RELATION_RECEIVED_BY = "Received by";
    public static final String RELATION_RECEIVE = "Receive";

    //structType/aliasType->interface
    public static final String RELATION_IMPLEMENT = "Implement";
    public static final String RELATION_IMPLEMENTED_BY = "Implemented by";

    //file->package
    public static final String RELATION_IMPORT = "Import";

    //function-function; function->method; method->function; method->method
    public static final String RELATION_CALL = "Call";

    //function/method->var
    public static final String RELATION_PARAMETER = "Parameter";

    //function/method->var
    public static final String RELATION_RETURN = "Return";

    //function/method->OperandVar
    public static final String RELATION_SET = "Set";

    //function/method->OperandVar
    public static final String RELATION_USE = "Use";

    //class->class in python
    //struct-> struct , interface->interface in golang
    public static final String RELATION_INHERIT = "Inherit";
    
	public static final String RELATION_DEFINE = "Define";

    //struct1->struct2, interface1->interface2
    //public static final String RELATION_INHERIT = "Embed";
    //public static final String RELATION_INHERITED_BY = "Embeded by";

	public static final ArrayList<String> resolveMask(String depMask) {
        ArrayList<String> depedencyTypes = new ArrayList<String>();
        for(int i = 0; i < depMask.toCharArray().length; i++) {
            if(depMask.toCharArray()[i] == '1') {
                if(i == 0) {
                    depedencyTypes.add(RELATION_IMPORT);
                }
                else if (i == 1) {
                    depedencyTypes.add(RELATION_INHERIT);
                }
                else if (i == 2) {
                    depedencyTypes.add(RELATION_IMPLEMENT);
                }
                else if (i == 3) {
                    depedencyTypes.add(RELATION_RECEIVE);
                }
                else if (i == 4) {
                    depedencyTypes.add(RELATION_CALL);
                }
                else if (i == 5) {
                    depedencyTypes.add(RELATION_SET);
                }
                else if (i == 6) {
                    depedencyTypes.add(RELATION_USE);
                }
                else if (i == 7) {
                    depedencyTypes.add(RELATION_PARAMETER);
                }
                else if (i == 8) {
                    depedencyTypes.add(RELATION_RETURN);
                }
            }
        }
        return depedencyTypes;
    }

}
