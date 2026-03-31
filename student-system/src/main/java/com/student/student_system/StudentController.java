package com.student.student_system;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class StudentController {

    // 1. 个人信息
    @GetMapping("/getUserInfo")
    public User getUserInfo() {
        return new User("湖北最忧郁之人", 20, "大二", "软件工程");
    }

    @GetMapping("/getSchedule")
    public Map<Integer, String> getSchedule() {
        Map<Integer, String> schedule = new HashMap<>();

        schedule.put(1,
                "高等数学 | 大学英语 | Java 编程 | 数据结构 || 大学物理 | 体育 + 大学英语 | 马克思原理 | 计算机网络 | 数据库原理 | 线性代数 | 概率论 | 心理健康 + Python 编程 | 软件工程 | Java 编程 | 数字逻辑 | 形势政策 | 创新创业 | 普通话 + 毛概 | C 语言 | Linux 系统 | UI 设计 | 离散数学 | 美术鉴赏 | 职业规划"
        );

        schedule.put(2,
                "高等数学 | 大学英语 | Java 编程 | 数据结构 || 线性代数 | 计算机基础 + 大学英语 | 离散数学 | 美术鉴赏 | 体育保健 | 创新创业 | 形势政策 | 毛概 + 概率论 | 操作系统 | Java 编程 | 网页设计 | 网络安全 | 商务礼仪 | 高数习题 + 演讲口才 | 影视赏析 | 信息安全 | 大数据入门 | 逻辑学 | 乐理基础 | 瑜伽选修"
        );

        schedule.put(3,
                "高等数学 | 大学英语 | Java 编程 | 数据结构 || 线性代数 | 计算机基础 + 大学英语 | 离散数学 | 美术鉴赏 | 体育保健 | 创新创业 | 形势政策 | 毛概 + 概率论 | 操作系统 | Java 编程 | 网页设计 | 网络安全 | 商务礼仪 | 高数习题 + 演讲口才 | 影视赏析 | 信息安全 | 大数据入门 | 逻辑学 | 乐理基础 | 瑜伽选修"
        );

        schedule.put(4,
                "高等数学 | 大学英语 | Java 编程 | 数据结构 || 概率论 | 马原概论 + 大学英语 | 软件工程 | Linux 运维 | 算法入门 | 普通话 | 就业指导 | 体能训练 + 大学物理 | 影视鉴赏 | Java 编程 | 数据库实战 | 平面设计 | 合唱艺术 | 法律基础 + 社交礼仪 | 云计算基础 | 人工智能导论 | 图形学基础 | 应用文写作 | 历史通识 | 哲学概论"
        );

        schedule.put(5,
                "高等数学 | 大学英语 | Java 编程 | 数据结构 || 大学物理 | 体育 + 大学英语 | 马克思原理 | 计算机网络 | 数据库原理 | 线性代数 | 概率论 | 心理健康 + Python 编程 | 软件工程 | Java 编程 | 数字逻辑 | 形势政策 | 创新创业 | 普通话 + 毛概 | C 语言 | Linux 系统 | UI 设计 | 离散数学 | 美术鉴赏 | 职业规划"
        );

        return schedule;
    }

    // 成绩：不及格分数自动标红
    @GetMapping("/getScore")
    public Map<String, Integer> getScore() {
        Map<String, Integer> score = new HashMap<>();
        score.put("Java编程", 95);
        score.put("大学英语", 90);
        score.put("计算机基础", 92);
        score.put("高等数学", 58);
        return score;
    }
}