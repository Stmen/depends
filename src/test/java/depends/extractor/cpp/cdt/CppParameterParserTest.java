package depends.extractor.cpp.cdt;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import depends.extractor.cpp.CppFileParser;

public class CppParameterParserTest extends CdtParserTest{
    @Before
    public void setUp() {
    	super.init();
    }
	
	@Test
	public void test_parameter() throws IOException {
	    String src = "./src/test/resources/cpp-code-examples/FunctionParameters.cpp";
	    CppFileParser parser = new  CdtCppFileParser(src,repo, new ArrayList<>(), fileIndex );
        parser.parse();
        repo.resolveAllBindings();
        assertEquals(4,repo.getEntity("FunctionParameters.function_with_parameters_same_type").getRelations().size());
	}

}
