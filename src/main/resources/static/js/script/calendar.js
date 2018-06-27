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
                defaultView: 'agendaWeek',
                events : [{
                    title: "Event 1",
                    start : moment().startOf("week").add(1, 'days'),
                    end : moment().startOf('week').add({
                        'days':1,
                        'hours' : 3
                    }),
                    color: "blue",
                }]
            });
        })

    })
})

