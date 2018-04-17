package com.simba.framework.util.python;

import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.util.LinkedList;
import java.util.List;


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

    public static void main(String[] args) {
        String filePath = "src\\main\\java\\com\\simba\\framework\\util\\python\\test.py";
        PythonUtil pythonUtil = new PythonUtil("C:\\jython2.7b1\\Lib");
        pythonUtil.executeScript("print(123)");
    }

}
