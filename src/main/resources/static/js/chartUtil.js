export default {
    create({ type, data, id }) {
        new Chart($('#' + id), {
            type: type,
            data: data,
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            },
        });
    }
}
