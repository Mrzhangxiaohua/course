package com.spc.service.student.studentEvaluate.impl;

import com.spc.controller.Base;
import com.spc.dao.studentDao.studentEvaluateDao.StudentEvaluateDao;
import com.spc.service.student.studentEvaluate.StudentEvaluateService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/3/20 12:58
 */
@Service
public class StudentEvaluateServiceImpl extends Base implements StudentEvaluateService {

    @Autowired
    StudentEvaluateDao studentEvaluateDao;

    /**
     * 根据学生id得到学生选课情况及是否评论，未评论isComment为0，否则为1
     * @param stuId
     * @return
     */
    @Override
    public List<Map<String, Object>> selectList(String stuId) {
        List<Map<String, Object>> list = studentEvaluateDao.selectList(stuId);
        System.out.println(list);
        // 对学生所选课程遍历查询是否已评教
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("isComment")==null){
                list.get(i).put("isComment", '0');//0表示未评教
            }else {
                list.get(i).put("isComment", '1');
            }
        }
        return list;
    }

    @Override
    public int stuEvaluate(Integer classId, String stuId, JSONArray score1, JSONArray score2, JSONArray score3) {
        String json = "{\n" +
                "    \"classId\":480,\n" +
                "    \"stuId\":3118105316,\n" +
                "    \"score1\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"8\",\"9\",\"10\"],\n" +
                "    \"score2\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"税收数\",\"8\",\"9\",\"10\"],\n" +
                "    \"score3\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"我是\",\"7\",\"8\",\"9\",\"10\"]\n" +
                "}";
        try {
            JSONObject obj = new JSONObject(json);
            Integer classId1 = obj.getInt("classId");
            Integer stuId1 = obj.getInt("stuId");
            JSONArray score11 = obj.getJSONArray("score1");
            JSONArray score21 = obj.getJSONArray("score2");
            JSONArray score31 = obj.getJSONArray("score3");
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for (int i = 0; i < score11.length(); i++) {
                try {
                    sb1.append(score11.get(i) + ",");
                    sb2.append(score21.get(i) + ",");
                    sb3.append(score31.get(i) + ",");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            String strScore1 = "" + sb1;
            String strScore2 = "" + sb2;
            String strScore3 = "" + sb3;
            return studentEvaluateDao.stuEvaluate(classId, stuId, strScore1, strScore2, strScore3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
