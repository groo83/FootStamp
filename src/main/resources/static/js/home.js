if (!navigator.geolocation) {
    status.textContent = "브라우저가 위치 정보를 지원하지 않음";
} else {
    status.textContent = "위치 파악 중…";
    navigator.geolocation.getCurrentPosition(success, error);
}

function success(position) {
    const latitude = position.coords.latitude;
    const longitude = position.coords.longitude;

	let formData = new FormData(); // new FromData()로 새로운 객체 생성
    formData.append('mapx',longitude); // <input name="item" value="hi"> 와 같다.
    formData.append('mapy',latitude);

	let urlFormData = new URLSearchParams(formData)

    // TODO redirect 이동 불가 이슈 처리
    fetch("/search/registerableStamp", {
      method: "POST",
      redirect: "follow",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
      body: urlFormData
    }).then((response) => console.log(response))
      .catch((error) => console.log("error:", error));
}