package com.simba.framework.util.python;

import java.util.LinkedList;
import java.util.List;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;


/**
 * Created by linshuo on 2018/4/17.
 */
public class PythonUtil {
    private PythonInterpreter interpreter;

    public PythonUtil(String jythonLibPath) {
        PySystemState ps = Py.getSystemState();
        ps.path.add(jythonLibPath);
        interpreter = new PythonInterpreter();
    }

    public Object executeScript(String script, String functionName, Object[] params) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.compile(script);
        PyFunction func = interpreter.get(functionName, PyFunction.class);
        if (params == null || params.length == 0) return func.__call__();
        List<PyObject> pyObjectList = new LinkedList<>();
        for (Object param : params) {
            if (param instanceof Integer)
                pyObjectList.add(new PyInteger((Integer) param));
            else if (param instanceof String)
                pyObjectList.add(new PyString((String) param));
        }
        PyObject[] paramz = new PyObject[pyObjectList.size()];
        pyObjectList.toArray(paramz);
        PyObject result = func.__call__(paramz);
        return result.toString();
    }

    public void executeScript(String script) {
        interpreter.exec(script);
    }

    public void executeScriptFile(String filePath) {
        interpreter.execfile(filePath);
    }

}
