const currentPosition =function(){
    if (!navigator.geolocation) {
        status.textContent = "브라우저가 위치 정보를 지원하지 않음";
    } else {
        status.textContent = "위치 파악 중…";
        navigator.geolocation.getCurrentPosition(success, error);
    }
}
function success(position) {
    const latitude = position.coords.latitude;
    const longitude = position.coords.longitude;
    console.log(latitude +', '+ longitude);
    kakaoMapApi(latitude, longitude);
}

// kakaoMap 통신
function kakaoMapApi(latitude, longitude)
{
    var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스

    var options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(latitude, longitude), //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
    };

    var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
}

function error(error) {
    alert("현재 위치를 가져올 수 없음");
}