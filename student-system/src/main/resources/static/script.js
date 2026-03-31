// Tab切换
const tabBtns = document.querySelectorAll('.tab-item');
const tabPanels = document.querySelectorAll('.tab-panel');

tabBtns.forEach(tab => {
    tab.addEventListener('click', () => {
        tabBtns.forEach(item => item.classList.remove('active'));
        tabPanels.forEach(panel => panel.classList.remove('active'));
        tab.classList.add('active');
        document.getElementById(tab.dataset.target).classList.add('active');
    });
});

// 个人信息
fetch('http://localhost:8080/getUserInfo')
    .then(res => res.json())
    .then(data => {
        document.getElementById('userName').textContent = data.name;
        document.getElementById('userAge').textContent = data.age;
        document.getElementById('userGrade').textContent = data.grade;
        document.getElementById('userMajor').textContent = data.major;
    });

let scheduleData = {};
const weekSelect = document.getElementById('weekSelect');
const scheduleBody = document.getElementById('scheduleBody');
const dayList = ['周一', '周二', '周三', '周四', '周五', '周六', '周日'];
const sectionCount = 4;

// 初始化课表
fetch('http://localhost:8080/getSchedule')
    .then(res => res.json())
    .then(data => {
        scheduleData = data;
        renderSchedule(1);
    });
function renderSchedule(week) {
    const weekCourseStr = scheduleData[week] || "";
    const courseArr = weekCourseStr.split('|');
    let html = '';

    for (let i = 0; i < sectionCount; i++) {
        html += '<tr>';
        html += '<td></td>'; // 节次列完全留白
        for (let j = 0; j < dayList.length; j++) {
            const index = i * dayList.length + j;
            const course = index < courseArr.length ? courseArr[index].trim() : "无课程";
            html += `<td>${course || "无课程"}</td>`;
        }
        html += '</tr>';
    }
    scheduleBody.innerHTML = html;
}

// 周数切换
weekSelect.addEventListener('change', () => {
    renderSchedule(weekSelect.value);
});

// 3. 成绩：<60自动标红
fetch('http://localhost:8080/getScore')
    .then(res => res.json())
    .then(data => {
        const scoreBody = document.getElementById('scoreBody');
        let html = '';
        for (let course in data) {
            const score = data[course];
            const failClass = score < 60 ? 'score-fail' : '';
            html += `<tr><td>${course}</td><td class="${failClass}">${score} 分</td></tr>`;
        }
        scoreBody.innerHTML = html;
    });