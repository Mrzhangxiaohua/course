require(['jquery', 'moment', 'jquery_ui'], function ($, moment, b) {
    require(['jqs'], function (jqs) {
        $(document).ready(function () {
            console.log("run here")
            $("#calendars").jqs({

                mode: "read", // read
                hour: 24, // 12
                periodDuration: 60, // 15/30/60
                data: [ {
                    day: 0,
                    periods: [
                        ["08:00", "12:00"],
                        ["14:00", "21:00"]
                    ]
                }],
                periodOptions: true,
                periodColors: [],
                periodTitle: "",
                periodBackgroundColor: "rgba(82, 155, 255, 0.5)",
                periodBorderColor: "#2a3cff",
                periodTextColor: "#000",
                periodRemoveButton: "Remove",
                periodDuplicateButton: 'Duplicate',
                periodTitlePlaceholder: "Title",
                days: [
                    "Monday",
                    "Tuesday",
                    "Wednesday",
                    "Thursday",
                    "Friday",
                    "Saturday",
                    "Sunday"
                ],
                onInit: function () {},
                onAddPeriod: function () {},
                onRemovePeriod: function () {},
                onClickPeriod: function () {},
                onDuplicatePeriod: function () {},

            });
        })
    })
})

