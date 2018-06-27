require(['jquery','moment','jquery_ui','zhcn'],function ($,moment,b,c) {
    require(['fullcalendar'], function () {
        $(document).ready(function () {
            console.log("run here")

            $('#calendars').fullCalendar({
                //lang: 'de',
                header: {
                    left: '',
                    center: '',
                    right: ''
                },
                defaultView: 'agendaWeek',
                minTime: '08:00:00',
                maxTime: '21:00:00',
                defaultDate: '2014-06-12',
                height : 550,
                defaultTimedEventDuration: '02:00:00',
                editable: true,
                events: [{
                    title: 'All Day Event',
                    start: '2014-06-01'
                }, {
                    title: 'Long Event',
                    start: '2014-06-07',
                    end: '2014-06-10'
                }, {
                    id: 999,
                    title: 'Repeating Event',
                    start: '2014-06-09T16:00:00'
                }, {
                    id: 999,
                    title: 'Repeating Event',
                    start: '2014-06-16T16:00:00'
                }, {
                    title: 'Meeting',
                    start: '2014-06-12T10:30:00',
                    end: '2014-06-12T12:30:00'
                }, {
                    title: 'Lunch',
                    start: '2014-06-12T12:00:00'
                }, {
                    title: 'Birthday Party',
                    start: '2014-06-13T07:00:00'
                }, {
                    title: 'Click for Google',
                    url: 'http://google.com/',
                    start: '2014-06-28'
                }],
                viewRender: function(view) {
                    startedViewRender = true;
                }
            });
        })

    })
})

