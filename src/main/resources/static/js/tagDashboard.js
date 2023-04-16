import chartUtil from "./chartUtil.js";
$(function () {
    fetch('/test/tag/op/list')
        .then(response => response.json())
        .then(data => renderOpList(data));
    
    fetch('/test/tag/owner/list')
        .then(response => response.json())
        .then(data => renderOwnerList(data));

    const renderOpList = (data) => {
        const chartData = {
            labels: data.map(row => row.date),
            datasets: [{
                label: '更新次数',
                data: data.map(row => row.count),
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            }]
        };
        chartUtil.create({ type: 'bar', data: chartData, id: 'opListChart' });
    }

    const renderOwnerList = (data) => {
        const chartData = {
            labels: [],
            datasets: [{
                label: '主管部门',
                data: data['departmentList'].map(row => row.count),
                backgroundColor: 'rgba(54, 10, 12, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            },
            {
                label: '所属支行',
                data: data['subBranchList'].map(row => row.count),
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            }]
        }
        chartUtil.create({ type: 'bar', data: chartData, id: 'ownerListChart' });
    }
})