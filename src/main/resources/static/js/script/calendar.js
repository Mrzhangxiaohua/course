require(['jquery','moment','jquery_ui','zhcn'],function ($,a,b,c) {
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
                // eventSources: ['events.php'],
                height: 680, // Fix height
                columnFormat: 'dddd', // Display just full length of weekday, without dates
                defaultView: 'agendaWeek', // display week view
                hiddenDays: [0,6], // hide Saturday and Sunday
                weekNumbers:  false, // don't show week numbers
                minTime: '08:00:00', // display from 16 to
                maxTime: '21:00:00', // 23
                slotDuration: '02:00:00', // 15 minutes for each row
                allDaySlot: false, // don't show "all day" at the top
                select: function(start, end, allDay) {

                    // Code for creating new events.
                    alert("Create new event at " + start);
                },
                eventResize: function( event, delta, revertFunc, jsEvent, ui, view ) {
                    // Code when you resize an event (for example make it two hours longer
                    alert("I just got resized!");
                },
                eventDrop: function( event, jsEvent, ui, view ) {

                    // Code when you drop an element somewhere else
                    alert("I'm somewhere else now");
                }
            });
        })

    })
})

