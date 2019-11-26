package com.jacky.interfaces.filters;

public class BandPass extends Filter {
	double lowCutoff, hithCutoff;

	public BandPass(double lowCut, double highCut) {
		this.lowCutoff = lowCut;
		this.hithCutoff = highCut;
	}

	public Waveform process(Waveform input) {
		return input;
	}
}
