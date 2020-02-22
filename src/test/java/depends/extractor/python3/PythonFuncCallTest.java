package depends.extractor.python3;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import depends.deptypes.DependencyType;
import depends.entity.FunctionEntity;
import depends.extractor.python3.PythonFileParser;

public class PythonFuncCallTest extends Python3ParserTest {
    @Before
    public void setUp() {
    	super.init();
    }

	
	@Test
	public void could_parse_func_call() throws IOException {
		String[] srcs = new String[] {
	    		"./src/test/resources/python-code-examples/func_call.py",
	    	    };
	    
	    for (String src:srcs) {
		    PythonFileParser parser = createParser(src);
		    parser.parse();
	    }
	    inferer.resolveAllBindings();
	    FunctionEntity func = (FunctionEntity)repo.getEntity(withPackageName(srcs[0],"foo"));
	    this.assertContainsRelation(func, DependencyType.CALL, withPackageName(srcs[0],"bar"));
	}

}