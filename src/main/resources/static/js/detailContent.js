/*
function fileChange(obj) {
	var filename;
	if(window.FileReader){
		filename = document.querySelector(obj)[0].files[0].name;
	} else {
		filename = document.querySelector(obj).value.split('/').pop().split('\\').pop();
	}

	var _fileLen = filename.length;
	var _lastDot = filename.lastIndexOf('.');

	// 확장자 체크
	var ext = filename.substring(_lastDot+1, _fileLen).toLowerCase();
	if ($.inArray(ext, ['gif', 'jpg', 'jpeg', 'png']) == -1){
		alert('gif, jpg, jpeg, png 파일만 업로드 해주세요.');
		return;
	}

	// 용량 체크
	var fileSize = obj.files[0].size;
	var maxSize = 1024 * 1024 * 10;	// 10MB
	if (fileSize > maxSize) {
		alert('최대 10MB까지 업로드 가능합니다.')
		return;
	}

	//if( appYn == 'Y' && getDevice() == 'Android') {
	//} else {
		var reader = new FileReader();
		reader.onload = function(e) {
			let type = 1;
			//if($(obj).closest('.replyForm').length)
				//type = 2;


			//$(obj).closest('.write').find('#commentfile').remove();

			var strHtml = '';
			if(type == 1){
				strHtml += '<div class="fileLayer" id="commentfile">';
			} else{
				strHtml += '<li class="file">';
				strHtml += '<div class="fileLayer">';
			}
			strHtml += '	<p>이미지 첨부는 최대 1개까지 가능합니다.</p>';
			strHtml += '	<span class="img">';
			strHtml += '		<img src="'+e.target.result+'" alt="">';
			strHtml += '		<button type="button" onclick="$(this).closest(\'.fileLayer\').remove();">삭제</button>';
			strHtml += '	</span>';

			strHtml += '</div>';
			if(type == 2)
				strHtml += '</li>';

			//$(obj).closest('.write').after(strHtml);
		}
		reader.readAsDataURL(obj.files[0]);
	//}
}*/

// chat

document.getElementById('fileInput').addEventListener('change', function(event) {
    const textInput = document.getElementById('textInput');
    const fileInput = event.target;
    const imageContainer = document.getElementById('imageContainer');
    const uploadForm = document.getElementById('uploadForm');

    if (fileInput.files && fileInput.files[0]) {//textInput.value &&
        const file = fileInput.files[0];
        const reader = new FileReader();

        reader.onload = function(e) {
            const imageWrapper = document.createElement('div');
            imageWrapper.className = 'image-container';

            const img = document.createElement('img');
            img.src = e.target.result;
            img.style.maxWidth = '100%';
            img.style.height = 'auto';
            img.style.marginBottom = '10px';
            img.style.position = 'relative';

            const deleteButton = document.createElement('button');
            deleteButton.textContent = '엑스';
            deleteButton.className = 'delete-button';
            deleteButton.addEventListener('click', function() {
                imageContainer.removeChild(imageWrapper);
                uploadedImage = null;
            });

            imageWrapper.appendChild(img);
            imageWrapper.appendChild(deleteButton);
            imageContainer.appendChild(imageWrapper);

            uploadedImage = file;

            // TODO
            // 예: fetch 또는 XMLHttpRequest를 사용하여 서버로 전송




            // 서버에 전달할 데이터 구성
            const formData = new FormData(uploadForm);
            formData.append('image', file);


        };

        reader.readAsDataURL(file);
    }
});

document.getElementById('uploadButton').addEventListener('click', function() {
            // 실제로는 이곳에서 서버로 데이터 전송하는 코드를 작성해야 합니다.
            // 예: fetch 또는 XMLHttpRequest를 사용하여 서버로 전송
});
