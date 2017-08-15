<%--suppress ALL --%>
<%@include file="/WEB-INF/include/root.jspf"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ticket</title>
    <link rel="stylesheet" type="text/css" href="css/print.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
</head>
<body onload="printPage()"><!---->
<script>
    function printPage() {
        window.print();
    }
</script>


<section class="main">
    <div id="whole">
        <img src="img/pass.jpg">
        <div id="all">
            <div id="block1">
                <div id="block3"></div>
                <div id="block4">
                    <div id="block51">
                        <div id="block5">
                            <div id="block5i">Passenger Name</div>
                            <div id="block5main">Anton Mazets</div>
                        </div>
                        <div id="block6">
                            <div id="block7">
                                <div id="block9">
                                    <div id="block9i">From</div>
                                    <div id="block9main">
                                        <c:out value="${flight.getFromDirection().getDirectionCode()}" />
                                        ,
                                        <c:out value="${flight.getFromDirection().getDirectionName()}" />
                                    </div>
                                </div>
                                <div id="block9">
                                    <div id="block9i">To</div>
                                    <div id="block9main">
                                        <c:out value="${flight.getToDirection().getDirectionCode()}" />
                                        ,
                                        <c:out value="${flight.getToDirection().getDirectionName()}" />
                                    </div>
                                </div>
                                <div id="block10">
                                    <div id="block10i">Flight</div>
                                    <div id="block10main">
                                        <c:out value="${flight.getFlightCode()}" />
                                    </div>
                                </div>
                                <div id="block11">
                                    <div id="block10i">Seat</div>
                                    <div id="block10main">14A</div>
                                </div>
                            </div>
                            <div id="block8">
                                <div id="block9">
                                    <div id="block9i">Carrier</div>
                                    <div id="block9main">Easy Fly</div>
                                </div>
                                <div id="block10">
                                    <div id="block10i">Date</div>
                                    <div id="block10main">
                                        <fmt:formatDate type="date" value="${flight.getDepartureDate()}" />
                                    </div>
                                </div>
                                <div id="block11">
                                    <div id="block10i">Time</div>
                                    <div id="block10main">
                                        <c:out value="${flight.getDepartureTime()}" />
                                    </div>
                                </div>
                                <div id="block12">
                                    <div id="block10i">Gate</div>
                                    <div id="block9main">22</div>
                                </div>
                                <div id="block13">
                                    <div id="block10i">Board till</div>
                                    <div id="block9main">08:10</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="block14"></div>
                </div>
            </div>
            <div id="block2">
                <div id="block15">
                    <div id="block16">
                        <div id="block16i">Passenger name</div>
                        <div id="block16main">Anton Mazets</div>
                    </div>
                    <div id="block16">
                        <div id="block16i">From</div>
                        <div id="block16main">
                            <c:out value="${flight.getFromDirection().getDirectionName()}" />
                        </div>
                    </div>
                    <div id="block16">
                        <div id="block16i">To</div>
                        <div id="block16main">
                            <c:out value="${flight.getToDirection().getDirectionName()}" />
                        </div>
                    </div>
                    <div id="block16">
                        <div id="block17">
                            <div id="block17i">Date</div>
                            <div id="block17main">
                                <fmt:formatDate type="date" value="${flight.getDepartureDate()}" />
                            </div>
                        </div>
                        <div id="block17">
                            <div id="block17i">Time</div>
                            <div id="block17main">
                                <c:out value="${flight.getDepartureTime()}" />
                            </div>
                        </div>
                        <div id="block17">
                            <div id="block17i">Gate</div>
                            <div id="block17main">22</div>
                        </div>
                    </div>
                    <div id="block16">
                        <div id="block17">
                            <div id="block17i">Flight</div>
                            <div id="block17main">
                                <c:out value="${flight.getFlightCode()}" />
                            </div>
                        </div>
                        <div id="block17">
                            <div id="block17i">Seat</div>
                            <div id="block17main">14A</div>
                        </div>
                        <div id="block17">
                            <div id="block17i">Board till</div>
                            <div id="block17main">08:40</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
</body>
</html>