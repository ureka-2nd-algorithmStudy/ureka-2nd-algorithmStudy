package simulation;

public class p_동영상재생기 {

	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		
		// 00:00 시간을 초단위로 변환
		int video_len_s = minutesToSeconds(video_len);
		int pos_s = minutesToSeconds(pos);
		int op_start_s = minutesToSeconds(op_start);
		int op_end_s = minutesToSeconds(op_end);
		
		// 현재 위치가 오프닝 구간일 경우 오프닝 끝 으로 이동
		if ( pos_s >= op_start_s && pos_s <= op_end_s) {
			pos_s = op_end_s;
		}
		
		// next, prev 에 대한 수행
		for ( String command : commands) {
			if ( command.equals("prev")) {
				pos_s -= 10; // prev 인 경우 10초 전으로 이동
				if ( pos_s < 0 ) {
					pos_s = 0; // 동영상 시작 시간인 0:0 이하면 0:0으로 이동
				}
			} else if ( command.equals("next")) {
				pos_s += 10; // next 인 경우 10초 앞으로 이동
				if ( pos_s > video_len_s) {
					pos_s = video_len_s; // 현재 위치가 동영상 전체 길이를 벗어나면 동영상 끝으로 이동
				}
			}
			
			// 오프닝 구간일 경우 오프닝 끝 구간으로 이동
			if ( pos_s >= op_start_s && pos_s <= op_end_s) {
				pos_s = op_end_s;
			}
		}
		
		return secondsTominutes(pos_s); // 초 단위를 00: 00  으로 변환
		
	}
	
	// 00:00 시간에 대한 값을 초단위로 변환하는 함수
	private int minutesToSeconds(String time) {
		String[] a = time.split(":");
		int minutes = Integer.parseInt(a[0]);
		int seconds = Integer.parseInt(a[1]);
		return minutes * 60 + seconds;
	}
	
	// 초단위 시간을 분:초 로 변환하는 함수
	private String secondsTominutes(int seconds) {
		int minutes = seconds / 60;
		int ssseconds = seconds % 60; // 초 나누기 60의 나머지가 초 의미 125초인 경우 2분 5초
		return String.format("%02d:%02d", minutes, ssseconds);
	}
}
