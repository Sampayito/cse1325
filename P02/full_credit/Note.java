public class Note {
	private Pitch pitch;
	private int octave;
	Note() {
		pitch = null;
	}
	Note(Pitch pitch, int octave) {
		this.pitch = pitch;
		if (octave < -5) {
			this.octave = -5;
		}
		else if (octave > 4) {
			this.octave = 4;
		}
	}
	@Override
	public String toString() {
		if (pitch.equals(null)) {
			return " ";
		}
		if (octave == 0) {
			return "" + pitch;
		}
		else {
			return "" + pitch + octave;
		}
	}
	
}
