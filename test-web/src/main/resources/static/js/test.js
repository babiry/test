timerID = setInterval('clock()',500); 
function clock() {
	document.getElementById("testTime").innerHTML = getNow();
}
function getNow() {
	var now = new Date();
	var year = now.getFullYear();
	var mon = now.getMonth()+1; //１を足すこと
	var day = now.getDate();
	var hour = now.getHours();
	var min = now.getMinutes();
	var sec = now.getSeconds();

	var s = year + "年" + mon + "月" + day + "日" + hour + "時" + min + "分" + sec + "秒"; 
	return s;
}

var req = new XMLHttpRequest();

$('#btnsend').on('click', function(){
	  $('#result').text('通信中...');
	  // Ajax通信を開始
	  $.ajax({
	    url: 'csvwirte',
	    type: 'GET',
	    dataType: 'json',
	    // フォーム要素の内容をハッシュ形式に変換
	    data: $('form').serializeArray(),
	    timeout: 5000,
	  })
	  .done(function(data) {
		  var req;
		  $('#result').text(data[0].value + data[0].count);
	      // 通信成功時の処理を記述
	  })
	  .fail(function() {
	      // 通信失敗時の処理を記述
	  });
	})