package com.spc.service.manage.evaluationDisplay.impl;

import com.spc.controller.Base;
import com.spc.dao.manageDao.EvaluationDisplayDao.EvaluationDisplayDao;
import com.spc.model.ClassDomain;
import com.spc.service.manage.evaluationDisplay.EvaluationDisplayService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/4/7 18:31
 */
@Service
public class EvaluationDisplayServiceImpl extends Base implements EvaluationDisplayService {

    @Autowired
    private EvaluationDisplayDao evaluationDisplayDao;

    @Override
    public Map<String, Object> getAllClassEvaluation(String classId) {
        System.out.println(evaluationDisplayDao.getAllClassEvaluation(classId));
        List<Map<String, Object>> evaluationList = evaluationDisplayDao.getAllClassEvaluation(classId);

        return evaluationListProcess(evaluationList);
    }

    @Override
    public List<Map<String, Object>> getExistInformation() {
        List<Map<String, Object>> info = evaluationDisplayDao.getExistInformation();
        return info;
    }

    @Override
    public List<Map> getCascade() {
        List<ClassDomain> classes = evaluationDisplayDao.getAllClasses();
        List<Map> res = new ArrayList<>();

        List<String> departTemp = new ArrayList<String>();
        List<String> classTemp = new ArrayList<String>();
        for (ClassDomain cd : classes) {
            //判断是否这个学院
            String departName = cd.getDepartName();
            int departId = cd.getDepartId();

            int classId = cd.getClassId();
            String className = cd.getClassName() + cd.getClassSemester();;
            String classNum = String.valueOf(cd.getClassNum());
            String allClassName = cd.getDepartName() + cd.getClassName() + cd.getClassSemester();

            boolean in = false;
            if (departTemp.size() != 0) {
                for (String s : departTemp) {
                    if (s.equals(departName)) in = true;
                }
            }
            if (!in) departTemp.add(departName);
            //没有这个学院
            if (!in) {
                //创造课程
                //创造学院
                Map departM = creatClassOrDepartMap(departName, departId);
                Map classM = creatClassOrDepartMap(className, classId);

                Map classStrM = creatClassStrMap(classNum, classId);

                addClassOrDepart(classM, classStrM);
                addClassOrDepart(departM, classM);

                res.add(departM);
                classTemp.add(allClassName);
                departTemp.add(departName);
                //有这个学院
            } else {
                //判断有没有这个课程
                boolean in2 = false;
                if (classTemp.size() != 0) {
                    for (String s : classTemp) {
                        if (s.equals(allClassName)) in2 = true;
                    }
                }
                if (!in2) classTemp.add(allClassName);
                if (!in2) {

                    Map classM = creatClassOrDepartMap(className, classId);
                    Map classStrM = creatClassStrMap(classNum, classId);
                    addClassOrDepart(classM, classStrM);
                    for (Map everyDe : res) {
                        if (everyDe.get("label").equals(departName)) {
                            addClassOrDepart(everyDe, classM);
                        }
                    }
                } else {//有这个课程
                    Map classStrM = creatClassStrMap(classNum, classId);
                    for (Map everyDe : res) {
                        if (everyDe.get("label").equals(departName)) {
                            List<Map> list = (List<Map>) everyDe.get("children");
                            for (Map everyClass : list) {
                                if (everyClass.get("label").equals(className)) {
                                    List<Map> list2 = (List<Map>) everyClass.get("children");
                                    list2.add(classStrM);
                                }
                            }
                        }
                    }
                }
            }
        }

//        logger.info(String.valueOf(res));
        return res;
    }

    public Map creatClassOrDepartMap(String className, int classId) {
        Map tempChild2 = new HashMap();
        tempChild2.put("value", 88888888);
        tempChild2.put("label", className);
        List<Map> res = new ArrayList<>();
        tempChild2.put("children", res);
        return tempChild2;
    }

    public Map creatClassStrMap(String classNum, int classId) {
        Map tempChild2 = new HashMap();
        tempChild2.put("value", classId);
        tempChild2.put("label", classNum + "班");
        return tempChild2;
    }

    public Map addClassOrDepart(Map classMap, Map classStrMap) {
        List<Map> res = (List<Map>) classMap.get("children");
        res.add(classStrMap);
        return classMap;
    }

    private Map<String, Object> evaluationListProcess(List<Map<String, Object>> evaluationList) {
        Map<String, Object> list = getCountResults(evaluationList);
        return list;
    }

    @NotNull
    private Map<String, Object> getCountResults(List<Map<String, Object>> evaluationList) {

        List<Map<String, Object>> list = new LinkedList<>();
        List<Map<String, Object>> list1 = new LinkedList<>();
        List<Map<String, Object>> list2 = new LinkedList<>();
        // 1. 一共有10个题
        for (int i = 0; i < 10; i++) {
            // 每一个题都创建一个map
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> map1 = new HashMap<>();
            Map<String, Object> map2 = new HashMap<>();
            // 拿到每个学生的评价
            for (int j = 0; j < evaluationList.size(); j++) {
                String[] score1 = String.valueOf(evaluationList.get(j).get("score1")).split(",");
                String[] score2 = String.valueOf(evaluationList.get(j).get("score2")).split(",");
                String[] score3 = String.valueOf(evaluationList.get(j).get("score3")).split(",");
                // 每个人都要进行遍历
                if (map.containsKey(score1[i])){
                    int count = (int) map.get(score1[i]);
                    map.put(score1[i], count + 1);
                }else {
                    map.put(score1[i], 1);
                }
                if (map1.containsKey(score2[i])){
                    int count = (int) map1.get(score2[i]);
                    map1.put(score2[i], count + 1);
                }else {
                    map1.put(score2[i], 1);
                }
                if (map2.containsKey(score3[i])){
                    int count = (int) map2.get(score3[i]);
                    map2.put(score3[i], count + 1);
                }else {
                    map2.put(score3[i], 1);
                }
            }


            list.add(map);
            list1.add(map1);
            list2.add(map2);
        }
        Map res = new HashMap();
        res.put("status", "SUCCESS");
        Map score = new HashMap();
        score.put("score1",list);
        score.put("score2",list1);
        score.put("score3",list2);

        res.put("data", score);
        logger.info(String.valueOf(res));
        return res;
    }

}
