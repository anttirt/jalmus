package net.jalmus;

public class PitchDef {
	public int pitch;
	public Clef clef;

	public PitchDef() {
		this.pitch = 0;
		this.clef = null;
	}

	public PitchDef(int pitch) {
		this.pitch = pitch;
		this.clef = null;
	}

	public String toString() {
		if(clef == null)
			return Integer.toString(pitch);
		else if(clef == Clef.TREBLE)
			return Integer.toString(pitch) + "T";
		else // if(clef == Clef.BASS)
			return Integer.toString(pitch) + "B";
	}

	public boolean equals(PitchDef rhs) {
		return pitch == rhs.pitch && clef == rhs.clef;
	}

	public static PitchDef parse(String def) {
		char cclef = def.charAt(def.length() - 1);
		PitchDef pd = new PitchDef();
		if(cclef == 'T') {
			pd.pitch = Integer.parseInt(def.substring(0, def.length() - 1));
			pd.clef = Clef.TREBLE;
		}
		else if(cclef == 'B') {
			pd.pitch = Integer.parseInt(def.substring(0, def.length() - 1));
			pd.clef = Clef.BASS;
		}
		else {
			pd.pitch = Integer.parseInt(def);
		}
		return pd;
	}
}
