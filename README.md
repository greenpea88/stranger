# stranger
비숲2 기념 심심해서 만들어본 방탈출 예제

<Android>
- 화면 전환 시 정보 넘기기 : intent
- 전환 된 화면에서 되돌아올 때 정보 넘기기 : startActivityForResult(intent,0) -> setResult(STATUS); finish(); -> @override onActivityResult()
- 변경된 앱 정보 종료 이후 재시작시 유지 : SharedPreferences
- 동작 예제
