require(['jquery','moment','jquery_ui','zhcn'],function ($,moment,b,c) {
    require(['fullcalendar'], function () {
        $(document).ready(function () {
            console.log("run here")

            $('#calendars').fullCalendar({
                //lang: 'de',
                header: { // Display nothing at the top
                    left: '',
                    center: '',
                    right: ''
                },
                height : 600,
                themeSystem: 'bootstrap3',
                defaultView: 'agendaWeek',
                slotMinutes : 120,
                firstDay:1,
                events : [{
                    title: "Event 1",
                    start : moment().startOf("week").add({
                        'days':1,
                        'hours' : 8
                    }),
                    end : moment().startOf('week').add({
                        'days':1,
                        'hours' : 10
                    }),
                    color: "blue",
                },{
                    title: "Event 2",
                    start : moment().startOf("week").add({
                        'days':0,
                        'hours' : 10
                    }),
                    end : moment().startOf('week').add({
                        'days':0,
                        'hours' : 12
                    }),
                    color: "blue",
                }]
            });
        })

    })
})

