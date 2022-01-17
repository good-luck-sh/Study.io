<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <title></title>
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" type="text/css" href="../../../resources/css/final1.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
 <div class="container">
        <div class="row mb-3">
            <h2>빠른예매</h2>
            <div class="col-9">
              <div class="box">
                    <div class="text-title">
                        <h3>관람인원선택</h3>
                        <button class="reset-button" type="button"><img src="../../../resources/css/asset/resetbutton.png" class="btn-reset-icon"/>초기화</button>
                    </div>
                </div>
            </div>
            <div class="all-check-people">
                <div class="check-people">
                    <p class="txt">성인</p>
                    <div class="count">
                        <button type="button" class="down" title="성인 좌석 선택 감소">
                            -
                        </button>
                        <div class="number">
                            <button type="button" class="now" title="성인 현재 좌석 선택 수" ticketgrpcd="TKA">
                                0
                            </button>
                        </div>
                        <button type="button" class="up" title="성인 좌석 선택 증가">+</button>
                    </div>
                </div>
                <div class="check-people">
                    <p class="txt">청소년</p>
                    <div class="count">
                        <button type="button" class="down" title="청소년 좌석 선택 감소">
                            -
                        </button>
                        <div class="number">
                            <button type="button" class="now" title="청소년 현재 좌석 선택 수" ticketgrpcd="TKY">
                                0
                            </button>
                        </div>
                        <button type="button" class="up" title="청소년 좌석 선택 증가">+</button>
                    </div>
                </div>
                <div class="check-people">
                    <p class="txt">우대</p>
                    <div class="count">
                        <button type="button" class="down" title="우대 좌석 선택 감소">
                            -
                        </button>
                        <div class="number">
                            <button type="button" class="now" title="우대 현재 좌석 선택 수" ticketgrpcd="TKS">
                                0
                            </button>
                        </div>
                        <button type="button" class="up" title="우대 좌석 선택 증가">+</button>
                    </div>
                </div>
            </div>
            <div class="seat-view">
                <div class="seat">
                    <img src="../../../resources/css/asset/img-theater-screen.png" alt="screen-seat" class="screen-seat">
                    <div class="seat-wrapper">
                        <div class="toggle-seat"></div>
                    </div>
                </div>
            </div>
        <div class="col-3">
            <div class="movie-container">
                <div>
                <form>
                <section class="mt-4 mb-3 pt-4 pb-3" style="max-width:720px;">
                <c:choose>
                	<c:when test="${empty seate}">
                		<div><p>등록된 좌석정보가 없습니다.</p></div>
                	</c:when>
                	<c:otherwise>
                		<c:forEach var="start" items="${seate.start }">
	             			<c:forEach var="end" items="${seate2.end }">
	             			<c:if test="#상영정보가 null이 아니면 not eq null">
                			<button style="position:absolute; left:411px; top:90px; width:20px;"><span>사용불가</span></button>
                			</c:if>
                			<c:if test="start eq null || end eq null">
                				이건 service와 controller에서 걸러야함 그리고 완성 후에는 script로 button클릭 조장님께 설명드리고 UI로 먼저 구현하기
                			</c:if>
	                			<button style="position:absolute; left:411px; top:90px; width:20px;"><span>선택가능</span></button>
	                		</c:forEach>
                		</c:forEach>
                	</c:otherwise>
                </c:choose>
                </section>
                </form>
                </div>
            </div>
        </div>
    </div>
    </div>
</body>
<script type="text/javascript">
	var seats=[];
	var initPos = "행";
	for()
</script>
</html>