// Ajax 요청응답 처리 담당
var xhr = null;

// 브라우저를 구별하여 xhr 객체를 생성
function getRequest(){
	
	if(window.ActiveXObject)
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	
	else 
		xhr = new XMLHttpRequest();
	
	 
}


// 사용자가 서버를 호출할 때 사용하는 함수
// 1)서버요청경로 2)파라미터 3)도착함수 4)요청방식 5)비동기식 여부
function sendRequest(url, param, callback, method, async){
	
	// xhr 생성
	getRequest();
	
	// 요청방식
	// RequestMethod.GET인 경우에만 GET으로 하고, POST를 default로 하자
	method = (method.toLowerCase() == "get")? "GET" : "POST";
	
	// 파라미터
	// Ajax에서 Get방식을 쓸 경우 param은 무조건 null이어야 한다
	// 따라서 url + ? + param으로 뒤에 붙여준다.
	param = (param == null || param == "")? null : param;
	
	if(method == "GET" && param != null)
		url = url + "?" + param;
	
	// 요청을 보내고 응답이 도착할 함수를 지정
	xhr.onreadystatechange = callback;
	
	// 요청정보지정
	xhr.open(method, url, async);
	
	// POST방식을 위해 헤더 설정
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	// 서버요청
	xhr.send(method == "POST"? param : null);
	
}
