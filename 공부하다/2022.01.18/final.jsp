<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <title></title>
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" type="text/css" href="../../../resources/css/final.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
 <div class="container">
        <div class="row mb-3">
            <div class="col">
                <h2>빠른 예매</h2>
            </div>
        </div>
        <div>
            <div class="my-box">
                <div class="day">
                    <button class="pre" type="button"></button>
                    <!-- 페이지 네이션으로 입력할 것 -->
                    <button class="mon" type="button"><strong>17.</strong>오늘</button>
                    <button class="mon" type="button"><strong>18.</strong>내일</button>
                    <button class="mon" type="button"><strong>19.</strong>수</button>
                    <button class="mon" type="button"><strong>20.</strong>목</button>
                    <button class="mon" type="button"><strong>21.</strong>금</button>
                    <button class="mon" type="button" class="sat"><strong>22.</strong>토</button>
                    <button class="mon" type="button" class="sun"><strong>23.</strong>일</button>
                    <button class="mon" type="button"><strong>24.</strong>월</button>
                    <button class="mon" type="button"><strong>25.</strong>화</button>
                    <button class="mon" type="button"><strong>26.</strong>수</button>
                    <button class="next" type="button"></button>
                    <button class="calender" type="button"></button>
                </div>
                <div class="movie-container">
                <div class="left-one">
                    <h3>영화</h3>
                    <div class="movie-name">
                        <button class="movie-name-button" type="button">전체</button>
                        <button class="movie-name-button" type="button">큐레이션</button>
                    </div>
                    <div class="movie-list">
                        <button class="movie-button" type="button" movie-nm="" movie-no="" img-path="">
                            <img src="../../../resources/css/asset/전체관람자.png" alt="allpeople"/>
                            <span class="txt">[불쇼이 발레 인 시네마]백조의 호수</span>
                            <img src="../../../resources/css/asset/ico-heart.png" alt="heart" class="buttonicon">
                        </button>
                        <button class="movie-button" type="button" movie-nm="" movie-no="" img-path="">
                            <img src="../../../resources/css/asset/전체관람자.png"/>
                            <span class="txt">[불쇼이 발레 인 시네마]백조의 호수</span>
                            <img src="../../../resources/css/asset/ico-heart.png" alt="heart" class="buttonicon">
                        </button>
                        <button class="movie-button" type="button" movie-nm="" movie-no="" img-path="">
                            <img src="../../../resources/css/asset/전체관람자.png"/>
                            <span class="txt">[불쇼이 발레 인 시네마]백조의 호수</span>
                            <img src="../../../resources/css/asset/ico-heart.png" alt="heart" class="buttonicon">
                        </button>
                        <button class="movie-button" type="button" movie-nm="" movie-no="" img-path="">
                            <img src="../../../resources/css/asset/전체관람자.png"/>
                            <span class="txt">[불쇼이 발레 인 시네마]백조의 호수</span>
                            <img src="../../../resources/css/asset/ico-heart.png" alt="heart" class="buttonicon">
                        </button>
                        <button class="movie-button" type="button" movie-nm="" movie-no="" img-path="">
                            <img src="../../../resources/css/asset/전체관람자.png"/>
                            <span class="txt">[불쇼이 발레 인 시네마]백조의 호수</span>
                            <img src="../../../resources/css/asset/ico-heart.png" alt="heart" class="buttonicon">
                        </button>
                        <button class="movie-button" type="button" movie-nm="" movie-no="" img-path="">
                            <img src="../../../resources/css/asset/전체관람자.png"/>
                            <span class="txt">[불쇼이 발레 인 시네마]백조의 호수</span>
                            <img src="../../../resources/css/asset/ico-heart.png" alt="heart" class="buttonicon">
                        </button>
                        <button class="movie-button" type="button" movie-nm="" movie-no="" img-path="">
                            <img src="../../../resources/css/asset/전체관람자.png"/>
                            <span class="txt">[불쇼이 발레 인 시네마]백조의 호수</span>
                            <img src="../../../resources/css/asset/ico-heart.png" alt="heart" class="buttonicon">
                        </button>
                        <button class="movie-button" type="button" movie-nm="" movie-no="" img-path="">
                            <img src="../../../resources/css/asset/전체관람자.png"/>
                            <span class="txt">[불쇼이 발레 인 시네마]백조의 호수</span>
                            <img src="../../../resources/css/asset/ico-heart.png" alt="heart" class="buttonicon">
                        </button>
                    </div>
                    <div class="movie-img">
                        <!--영화 선택하지 않았을 때 -->
                        <!--<p>모든영화<br>
                        목록에서 영화를 선택하세요</p>-->
                       <!--영화를 하나라도 선택했을 때--> 
                        <div class="choice-list" id="choiceMovieList">
                            <img src="#">
                            <!--영화 이미지 소스가 들어간다. 선택된 영화에만 button이 출력된다. -->
                            <button type="button" class="del"></button>
                        </div>
                        <div class="choice-list" id="choiceMovieList">
                             <!--영화 이미지 소스가 들어간다.-->
                             <button type="button" class="del"></button>
                        </div>
                        <div class="choice-list" id="choiceMovieList">
                             <!--영화 이미지 소스가 들어간다.-->
                            <button type="button" class="del"></button>
                        </div>
                    </div>
                </div>
                <div class="center-one">
                    <h3>극장</h3>
                    <div class="theater-list">
                        <button class="theater-all-button">전체</button>
                        <button class="theater-spacial-button">특별관</button>
                    </div>
                    <div class="list-theater-detail">
                        <div class="all-theater-list">
                            <button class="list-theater-button">선호극장(count수)</button>
                            <button class="list-theater-button">서울(count수)</button>
                            <button class="list-theater-button">경기</button>
                            <button class="list-theater-button">인천</button>
                            <button class="list-theater-button">대전/충청/세종</button>
                            <button class="list-theater-button">부산/대구/경상</button>
                        </div>
                        <div class="theater-choies">
                            <button class="theater-choies-button">강남</button>
                            <button class="theater-choies-button">강남대로(씨티)</button>
                            <button class="theater-choies-button">강동</button>
                            <button class="theater-choies-button">군자</button>
                            <button class="theater-choies-button">동대문</button>
                            <button class="theater-choies-button">강남</button>
                            <button class="theater-choies-button">강남대로(씨티)</button>
                            <button class="theater-choies-button">강동</button>
                            <button class="theater-choies-button">군자</button>
                            <button class="theater-choies-button">동대문</button>
                            <button class="theater-choies-button">강남</button>
                            <button class="theater-choies-button">강남대로(씨티)</button>
                            <button class="theater-choies-button">강동</button>
                            <button class="theater-choies-button">군자</button>
                            <button class="theater-choies-button">동대문</button>
                        </div>
                    </div>
                    <div class="theater-choies-check">
                        <!--선택안했을 경우
                        <p class="check-content">전체극장<br>
                            목록에서 극장을 선택하세요
                        </p> -->
                        <!--선택했을 경우 클릭하면 입력되고 아니면 열리지 않는다.-->
                        <div class="check-theater">
                            <div class="detail-check-theater">
                                <p class="detail-text"><button type="button" class="detail-check"></button><br>
                                "목동"
                                </p>
                            </div>
                        </div>
                        <div class="check-theater">
                            <div class="detail-check-theater">
                                <button type="button" class="detail-check"></button>
                            </div>
                        </div>
                        <div class="check-theater">
                            <div class="detail-check-theater">
                                <button type="button" class="detail-check"></button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="right-one">
                    <h3>시간</h3>
                    <div class="time-check">
                        <button class="pre-time-button" ></button>
                        <button class="time-check-button" data-time="">13</button>
                        <button class="time-check-button" data-time="">14</button>
                        <button class="time-check-button" data-time="">15</button>
                        <button class="time-check-button" data-time="">16</button>
                        <button class="time-check-button" data-time="">17</button>
                        <button class="time-check-button" data-time="">18</button>
                        <button class="time-check-button" data-time="">19</button>
                        <button class="time-check-button" data-time="">20</button>
                        <button class="time-check-button" data-time="">21</button>
                        <button class="time-check-button" data-time="">22</button>
                        <button class="next-time-button" ></button>
                    </div>
                    <div class="movie-check">
                        <button type="button"  class="btn-on" id="2201171311021" play-start-time="1725" play-de="20220117" play-seq="1" rpst-movie-no="21089201" brch-no="1311" theab-no="04" play-schdl-no="2201171311021" rest-seat-cnt="95" ctts-ty-div-cd="MVCT01" theab-popup-at="Y" theab-popup-no="1313" >
                            <div class="legend"></div>
                            <span class="time">
                                <strong title="상영시작">17:25</strong>
                                <em title="상영종료">~20:13</em>
                            </span>
                            <span class="title">
                                <strong title="하우스 오브 구찌">하우스 오브 구찌</strong>
                                <em>2D(자막)</em>
                            </span>
                            <div class="info">
                                <span class="theater" title="극장">
                                    상봉<br>
                                    6층 4관[백신패스관]
                                </span>
                                <span class="seat">
                                    <strong class="now" title="잔여 좌석">95</strong>
                                    <em class="all" title="전체 좌석">/154</em>
                                </span>
                            </div>
                        </button>
                        <button type="button"  class="btn-on" id="2201171311021" play-start-time="1725" play-de="20220117" play-seq="1" rpst-movie-no="21089201" brch-no="1311" theab-no="04" play-schdl-no="2201171311021" rest-seat-cnt="95" ctts-ty-div-cd="MVCT01" theab-popup-at="Y" theab-popup-no="1313" >
                            <div class="legend"></div>
                            <span class="time">
                                <strong title="상영시작">17:25</strong>
                                <em title="상영종료">~20:13</em>
                            </span>
                            <span class="title">
                                <strong title="하우스 오브 구찌">하우스 오브 구찌</strong>
                                <em>2D(자막)</em>
                            </span>
                            <div class="info">
                                <span class="theater" title="극장">
                                    상봉<br>
                                    6층 4관[백신패스관]
                                </span>
                                <span class="seat">
                                    <strong class="now" title="잔여 좌석">95</strong>
                                    <em class="all" title="전체 좌석">/154</em>
                                </span>
                            </div>
                        </button>
                        <button type="button"  class="btn-on" id="2201171311021" play-start-time="1725" play-de="20220117" play-seq="1" rpst-movie-no="21089201" brch-no="1311" theab-no="04" play-schdl-no="2201171311021" rest-seat-cnt="95" ctts-ty-div-cd="MVCT01" theab-popup-at="Y" theab-popup-no="1313" >
                            <div class="legend"></div>
                            <span class="time">
                                <strong title="상영시작">17:25</strong>
                                <em title="상영종료">~20:13</em>
                            </span>
                            <span class="title">
                                <strong title="하우스 오브 구찌">하우스 오브 구찌</strong>
                                <em>2D(자막)</em>
                            </span>
                            <div class="info">
                                <span class="theater" title="극장">
                                    상봉<br>
                                    6층 4관[백신패스관]
                                </span>
                                <span class="seat">
                                    <strong class="now" title="잔여 좌석">95</strong>
                                    <em class="all" title="전체 좌석">/154</em>
                                </span>
                            </div>
                        </button>
                        <button type="button"  class="btn-on" id="2201171311021" play-start-time="1725" play-de="20220117" play-seq="1" rpst-movie-no="21089201" brch-no="1311" theab-no="04" play-schdl-no="2201171311021" rest-seat-cnt="95" ctts-ty-div-cd="MVCT01" theab-popup-at="Y" theab-popup-no="1313" >
                            <div class="legend"></div>
                            <span class="time">
                                <strong title="상영시작">17:25</strong>
                                <em title="상영종료">~20:13</em>
                            </span>
                            <span class="title">
                                <strong title="하우스 오브 구찌">하우스 오브 구찌</strong>
                                <em>2D(자막)</em>
                            </span>
                            <div class="info">
                                <span class="theater" title="극장">
                                    상봉<br>
                                    6층 4관[백신패스관]
                                </span>
                                <span class="seat">
                                    <strong class="now" title="잔여 좌석">95</strong>
                                    <em class="all" title="전체 좌석">/154</em>
                                </span>
                            </div>
                        </button>
                        <button type="button"  class="btn-on" id="2201171311021" play-start-time="1725" play-de="20220117" play-seq="1" rpst-movie-no="21089201" brch-no="1311" theab-no="04" play-schdl-no="2201171311021" rest-seat-cnt="95" ctts-ty-div-cd="MVCT01" theab-popup-at="Y" theab-popup-no="1313" >
                            <div class="legend"></div>
                            <span class="time">
                                <strong title="상영시작">17:25</strong>
                                <em title="상영종료">~20:13</em>
                            </span>
                            <span class="title">
                                <strong title="하우스 오브 구찌">하우스 오브 구찌</strong>
                                <em>2D(자막)</em>
                            </span>
                            <div class="info">
                                <span class="theater" title="극장">
                                    상봉<br>
                                    6층 4관[백신패스관]
                                </span>
                                <span class="seat">
                                    <strong class="now" title="잔여 좌석">95</strong>
                                    <em class="all" title="전체 좌석">/154</em>
                                </span>
                            </div>
                        </button>
                        <button type="button"  class="btn-on" id="2201171311021" play-start-time="1725" play-de="20220117" play-seq="1" rpst-movie-no="21089201" brch-no="1311" theab-no="04" play-schdl-no="2201171311021" rest-seat-cnt="95" ctts-ty-div-cd="MVCT01" theab-popup-at="Y" theab-popup-no="1313" >
                            <div class="legend"></div>
                            <span class="time">
                                <strong title="상영시작">17:25</strong>
                                <em title="상영종료">~20:13</em>
                            </span>
                            <span class="title">
                                <strong title="하우스 오브 구찌">하우스 오브 구찌</strong>
                                <em>2D(자막)</em>
                            </span>
                            <div class="info">
                                <span class="theater" title="극장">
                                    상봉<br>
                                    6층 4관[백신패스관]
                                </span>
                                <span class="seat">
                                    <strong class="now" title="잔여 좌석">95</strong>
                                    <em class="all" title="전체 좌석">/154</em>
                                </span>
                            </div>
                        </button>
                    </div>
                </div>
            </div>
            </div>
            <div class="side-advertise">
                <div>
                    <img src="asset/광고1.jpg" alt="advertisement" class="side-advertise-show">
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="advertise-footer">
                <img src="../../../resources/css/asset/광고.jpg" alt="advertisement">
            </div>
        </div>
      </div>
</body>
</html>