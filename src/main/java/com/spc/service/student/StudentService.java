package com.spc.service.student;

import java.util.HashMap;
import java.util.List;

public interface StudentService {
    public List<HashMap<String,String>> findClasses(int stuId);
}
