if (!navigator.geolocation) {
    status.textContent = "브라우저가 위치 정보를 지원하지 않음";
} else {
    status.textContent = "위치 파악 중…";
    navigator.geolocation.getCurrentPosition(success, error);
}

function success(position) {
    document.querySelector("[name=mapx]").value = position.coords.longitude;
    document.querySelector("[name=mapy]").value = position.coords.latitude;

    document.form.submit();

    // TODO fetch data table
    /*
    let formData = new FormData(); // new FromData()로 새로운 객체 생성
    formData.append('mapx',longitude); // <input name="item" value="hi"> 와 같다.
    formData.append('mapy',latitude);

    let urlFormData = new URLSearchParams(formData);

    fetch("/search/registerableStamp", {
      method: "POST",
      redirect: "follow",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
      body: urlFormData
    }).then((response) =>  console.log(response.json()))
      .then((json) =>
                console.log(json);
                document.querySelector("registerableTable").innerHTML+= "<tbody>";
                for(i=0;i<json.length;i++){
                    document.querySelector("registerableTable").innerHTML+=
                      "<tr>"+
                      "<td>" + json[i].id + "</td>"+
                      "<td> " +json[i].title +"</td>"+
                      "<td> " +json[i].body + "</td>"+
                      "</tr>";
                }
                document.querySelector("registerableTable").innerHTML+= "</tbody>";
            )
      .catch((error) => console.log("error:", error));
      */
}

function error(error) {
    alert("현재 위치를 가져올 수 없음");
}