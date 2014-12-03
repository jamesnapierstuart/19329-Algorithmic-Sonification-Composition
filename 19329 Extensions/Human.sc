/*

Human Class, creates an instance of a human being.

Includes high level features such as age, gender, smoker and cholesterol levels.
Calculates the risk of having a heart attack in the next 10 years.

Values of variables are randomly generated within guidelines of calculation:
http://www.framinghamheartstudy.org/risk/hrdcoronary.html

Online calculation found here (But calculation method below all self=created):
http://hp2010.nhlbihin.net/atpiii/calculator.asp

(c) 2013-2014, Candidate Number 19329

*/

Human

{
	var drumP, synthP, <>age, <>gender, <>totalCholesterol, <>hdlCholesterol, <>smoker, <>systolicBloodPressure, <>treatment, <>preference, <>totalPoints = 0, <>risk = "not calculated yet", <>synth = "kickJ", <>distortion = 0, <>reverb = 0, <>delay = 0, <>lforate = 0, <>attack = 0.6, <>rhythm = 0, <>drumPattern, <>synthPattern, <>osc = 0;


	*new {	arg drumP = DrumPatterns(), synthP = SynthPatterns(), age = 60.rand+20, gender = ["male", "female"].choose, totalCholesterol = 191.rand+130, hdlCholesterol = 81.rand+20, smoker = [true, false].choose, systolicBloodPressure  = 111.rand+90, treatment = [true, false].choose, preference = [], synth = "kickJ", distortion = 0, reverb = 0, delay = 0, lforate = 0, attack = 0.6, osc = 0, rhythm=0, drumPattern, synthPattern;


		^super.newCopyArgs(drumP, synthP, age, gender, totalCholesterol, hdlCholesterol, smoker, systolicBloodPressure, treatment, preference, synth, distortion, reverb, delay, lforate, attack, rhythm, drumPattern, synthPattern, osc);

	}

	// Getter and Setter methods:

	// Return the age
	getAge {
		^age.value;
	}

	// Set the age
	setAge { arg age;
		this.age = age;
	}

	// Return the gender
	getGender {
		^gender.value;
	}

	// Set the gender
	setGender { arg gender;
		this.gender = gender;
	}

	// Return the total cholesterol
	getTc {
		^totalCholesterol.value;
	}

	// Set the total cholesterol
	setTc { arg totalCholesterol;
		this.totalCholesterol = totalCholesterol;
	}

	// Return the hdlCholesterol
	getHdl {
		^hdlCholesterol.value;
	}

	// Set the hdlCholesterol
	setHdl { arg hdlCholesterol;
		this.hdlCholesterol = hdlCholesterol;
	}

	// Return the smoker status
	getSmokerStatus {
		^smoker.value;
	}

	// Set the smoker status
	setSmokerStatus { arg smoker;
		this.smoker = smoker;
	}

	// Return the systolicBloodPressure
	getSbp {
		^systolicBloodPressure.value;
	}

	// Set the systolicBloodPressure
	setSbp { arg systolicBloodPressure;
		this.systolicBloodPressure = systolicBloodPressure;
	}

	// Return the treatment
	getTreatment {
		^treatment.value;
	}

	// Set the treatment
	setTreatment { arg treatment;
		this.treatment = treatment;
	}

	// Return the totalPoints
	getTotalPoints {
		^totalPoints.value;
	}

	// Set the totalPoints
	setTotalPoints { arg totalPoints;
		this.totalPoints = totalPoints;
	}

	// Return the risk
	getRisk {
		^risk.value;
	}

	// Set the risk
	setRisk { arg risk;
		this.risk = risk;
	}

	// Return preference
	getPreference { arg no;
		^preference[no].value;
	}

	// Set the preference
	setPreference { arg no, preference;
		this.preference[no] = preference;
	}

	//Get synth
	getSynth {
		^synth.value;
	}

	// get distortion level
	getDistortion {
		^distortion.value;
	}

	// get reverb level
	getReverb {
		^reverb.value;
	}

	// get delay time
	getDelay {
		^delay.value;
	}

	// get lfo rate
	getLforate {
		^lforate.value;
	}

	// get attack
	getAttack {
		^attack.value;
	}

	// get osc
	getOsc {
		^osc.value;
	}

	// get rhythm
	getRhythm {
		^rhythm.value;
	}

	// get drum Pattern array [0] = level, [1] = duration.
	getDrumPattern {
		^drumPattern.value;
	}

	// get synth Pattern
	getSynthPattern {
		^synthPattern.value;
	}


	/*
	Calculate risk of heart attack within next 10 years.
	Using point system from the Framingham heart Study
	http://www.framinghamheartstudy.org/risk/hrdcoronary.html
	Algorithm below was self-created, based upon point base scores from the study.
	Can be checked against the results of the calculator and will find it does exactly the correct job.
	*/

	/*
	Methods for the male
	*/

	// Age between 20-39
	age2039 {
		synth = "kickJ";
		case
		// Is a smoker
		{(smoker == true)} {
			distortion = 0.5;
			totalPoints = totalPoints +8;
			case
			// Aged between 20 - 34
			{(age > 19) && (age < 35)} {
				attack = 0.01;
				totalPoints = totalPoints -9;
			}
			// Aged between 35 - 39
			{(age > 34) && (age < 40)} {
				attack = 0.2;
				totalPoints = totalPoints -4;
			}
		}
		// Is a non-smoker
		{(smoker == false)} {
			distortion = 0;
			// No points
			case
			// Aged between 20 - 34
			{(age > 19) && (age < 35)} {
				attack = 0.01;
				totalPoints = totalPoints -9;
			}
			// Aged between 35 - 39
			{(age > 34) && (age < 40)} {
				attack = 0.2;
				totalPoints = totalPoints -4;
			}
		}
	}

	// Age between 40-49
	age4049 {
		synth = "cowBellJ";
		case
		// Is a smoker
		{(smoker == true)} {
			distortion = 0.5;
			totalPoints = totalPoints +5;
			case
			// Aged between 40 - 44
			{(age > 39) && (age < 45)} {
				attack = 0.01;
				// No points
			}
			// Aged between 45 - 49
			{(age > 44) && (age < 50)} {
				attack = 0.1;
				totalPoints = totalPoints +3;
			}
		}
		// Is a non-smoker
		{(smoker == false)} {
			distortion = 0;
			// No points
			case
			// Aged between 40 - 44
			{(age > 39) && (age < 45)} {
				attack = 0.01;
				// No points
			}
			// Aged between 45 - 49
			{(age > 44) && (age < 50)} {
				attack = 0.1;
				totalPoints = totalPoints +3;
			}
		}
	}

	// Age between 50-59
	age5059 {
		synth = "snareJ";
		case
		// Is a smoker
		{(smoker == true)} {
			distortion = 0.5;
			totalPoints = totalPoints +3;
			case
			// Aged between 50-54
			{(age > 49) && (age < 55)} {
				attack = 0.01;
				totalPoints = totalPoints +6;
			}
			// Aged between 55-59
			{(age > 54) && (age < 60)} {
				attack = 0.2;
				totalPoints = totalPoints +8;
			}
		}
		// Is a non-smoker
		{(smoker == false)} {
			distortion = 0;
			// No points
			case
			// Aged between 50-54
			{(age > 49) && (age < 55)} {
				attack = 0.01;
				totalPoints = totalPoints +6;
			}
			// Aged between 55-59
			{(age > 54) && (age < 60)} {
				attack = 0.2;
				totalPoints = totalPoints +8;
			}
		}
	}

	// Age between 60-69
	age6069 {
		synth = "tomJ";
		case
		// Is a smoker
		{(smoker == true)} {
			distortion = 0.5;
			totalPoints = totalPoints +1;
			case
			// Aged between 60-64
			{(age > 59) && (age < 65)} {
				attack = 0.01;
				totalPoints = totalPoints +10;
			}
			// Aged between 65-69
			{(age > 64) && (age < 70)} {
				attack = 0.1;
				totalPoints = totalPoints +11;
			}
		}
		// Is a non-smoker
		{(smoker == false)} {
			distortion = 0;
			// No points
			case
			// Aged between 50-54
			{(age > 59) && (age < 65)} {
				attack = 0.01;
				totalPoints = totalPoints +10;
			}
			// Aged between 65-69
			{(age > 64) && (age < 70)} {
				attack = 0.1;
				totalPoints = totalPoints +11;
			}
		}
	}

	// Age between 70-79
	age7079 {
		synth = ["hat1J", "hat2J"].choose;
		case
		// Is a smoker
		{(smoker == true)} {
			distortion = 0.5;
			totalPoints = totalPoints +1;
			case
			// Aged between 70-74
			{(age > 69) && (age < 75)} {
				attack = 0.01;
				totalPoints = totalPoints +12;
			}
			// Aged between 75-79
			{(age > 74) && (age < 80)} {
				attack = 0.1;
				totalPoints = totalPoints +13;
			}
		}
		// Is a non-smoker
		{(smoker == false)} {
			distortion = 0;
			// No points
			case
			// Aged between 70-74
			{(age > 69) && (age < 75)} {
				attack = 0.01;
				totalPoints = totalPoints +12;
			}
			// Aged between 75-79
			{(age > 74) && (age < 80)} {
				attack = 0.1;
				totalPoints = totalPoints +13;
			}
		}
	}


	// Treatment true and sbp < 120
	allAge {
		case
		// Aged between 20 - 39
		{(age > 19) && (age < 40)} {

			case
			// Tc below 160
			{(totalCholesterol < 160)} {
				delay = 0;
				// No points
				this.age2039();
			}
			// Tc between 160 - 199
			{(totalCholesterol > 159) && (totalCholesterol < 200) } {
				delay = 0.2;
				totalPoints = totalPoints +4;
				this.age2039();
			}
			// Tc between 200 - 239
			{(totalCholesterol > 199) && (totalCholesterol < 240) } {
				delay = 0.4;
				totalPoints = totalPoints +7;
				this.age2039();
			}
			// Tc between 240 - 279
			{(totalCholesterol > 239) && (totalCholesterol < 280) } {
				delay = 0.6;
				totalPoints = totalPoints +9;
				this.age2039();
			}
			// Tc is above or equal to 280
			{(totalCholesterol >= 280)} {
				delay = 0.8;
				totalPoints = totalPoints +11;
				this.age2039();
			}
		}

		// Aged between 40 - 49
		{(age > 39) && (age < 50)} {

			case
			// Tc below 160
			{(totalCholesterol < 160)} {
				delay = 0;
				// No points
				this.age4049();
			}
			// Tc between 160 - 199
			{(totalCholesterol > 159) && (totalCholesterol < 200) } {
				delay = 0.2;
				totalPoints = totalPoints +3;
				this.age4049();
			}
			// Tc between 200 - 239
			{(totalCholesterol > 199) && (totalCholesterol < 240) } {
				delay = 0.4;
				totalPoints = totalPoints +5;
				this.age4049();
			}
			// Tc between 240 - 279
			{(totalCholesterol > 239) && (totalCholesterol < 280) } {
				delay = 0.6;
				totalPoints = totalPoints +6;
				this.age4049();
			}
			// Tc is above or equal to 280
			{(totalCholesterol >= 280)} {
				delay = 0.8;
				totalPoints = totalPoints +8;
				this.age4049();
			}
		}

		// Aged between 50 - 59
		{(age > 49) && (age < 60)} {

			case
			// Tc below 160
			{(totalCholesterol < 160)} {
				delay = 0;
				// No points
				this.age5059();
			}
			// Tc between 160 - 199
			{(totalCholesterol > 159) && (totalCholesterol < 200) } {
				delay = 0.2;
				totalPoints = totalPoints +2;
				this.age5059();
			}
			// Tc between 200 - 239
			{(totalCholesterol > 199) && (totalCholesterol < 240) } {
				delay = 0.4;
				totalPoints = totalPoints +3;
				this.age5059();
			}
			// Tc between 240 - 279
			{(totalCholesterol > 239) && (totalCholesterol < 280) } {
				delay = 0.6;
				totalPoints = totalPoints +4;
				this.age5059();
			}
			// Tc is above or equal to 280
			{(totalCholesterol >= 280)} {
				delay = 0.8;
				totalPoints = totalPoints +5;
				this.age5059();
			}
		}

		// Aged between 60-69
		{(age > 59) && (age < 70)} {

			case
			// Tc below 160
			{(totalCholesterol < 160)} {
				delay = 0;
				// No points
				this.age6069();
			}
			// Tc between 160 - 199
			{(totalCholesterol > 159) && (totalCholesterol < 200) } {
				delay = 0.2;
				totalPoints = totalPoints +1;
				this.age6069();
			}
			// Tc between 200 - 239
			{(totalCholesterol > 199) && (totalCholesterol < 240) } {
				delay = 0.4;
				totalPoints = totalPoints +1;
				this.age6069();
			}
			// Tc between 240 - 279
			{(totalCholesterol > 239) && (totalCholesterol < 280) } {
				delay = 0.6;
				totalPoints = totalPoints +2;
				this.age6069();
			}
			// Tc is above or equal to 280
			{(totalCholesterol >= 280)} {
				delay = 0.8;
				totalPoints = totalPoints +3;
				this.age6069();
			}
		}

		// Aged between 70-79
		{(age > 69) && (age < 80)} {

			case
			// Tc below 160
			{(totalCholesterol < 160)} {
				delay = 0;
				// No points
				this.age7079();
			}
			// Tc between 160 - 199
			{(totalCholesterol > 159) && (totalCholesterol < 200) } {
				delay = 0.2;
				// No points
				this.age7079();
			}
			// Tc between 200 - 239
			{(totalCholesterol > 199) && (totalCholesterol < 240) } {
				delay = 0.4;
				// No points
				this.age7079();
			}
			// Tc between 240 - 279
			{(totalCholesterol > 239) && (totalCholesterol < 280) } {
				delay = 0.6;
				totalPoints = totalPoints +1;
				this.age7079();
			}
			// Tc is above or equal to 280
			{(totalCholesterol >= 280)} {
				delay = 0.8;
				totalPoints = totalPoints +1;
				this.age7079();
			}
		}
	}


	treatmentTest {
		case
		// Has treatment
		{(treatment == true)} {
			reverb = 0.5;

			case
			// SBP below 120
			{(systolicBloodPressure < 120)} {
				case
				{(rhythm == "straight")} {
					// Do the straight 3 or less note pattern
					drumPattern = drumP.getStraight120;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 3 or less note pattern
					drumPattern = drumP.getStraightOff120;
				}
				{(rhythm == "off")} {
					// Do the off 3 or less note pattern
					drumPattern = drumP.getOff120;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 3 or less note pattern
					drumPattern = drumP.getTriplet120;
				};
				// No points
				this.allAge();
			}

			// SBP between 120 - 129
			{(systolicBloodPressure > 119) && (systolicBloodPressure < 130)} {
				case
				{(rhythm == "straight")} {
					// Do the straight 4 note pattern
					drumPattern = drumP.getStraight129;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 4 note pattern
					drumPattern = drumP.getStraightOff129;
				}
				{(rhythm == "off")} {
					// Do the off 4 note pattern
					drumPattern = drumP.getOff129;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 4 note pattern
					drumPattern = drumP.getTriplet129;
				};
				totalPoints = totalPoints + 1;
				this.allAge();
			}

			// SBP between 130-139
			{(systolicBloodPressure > 129) && (systolicBloodPressure < 140)} {
				case
				{(rhythm == "straight")} {
					// Do the straight 5 note pattern
					drumPattern = drumP.getStraight130;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 5 note pattern
					drumPattern = drumP.getStraightOff130;
				}
				{(rhythm == "off")} {
					// Do the off 5 note pattern
					drumPattern = drumP.getOff130;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 5 note pattern
					drumPattern = drumP.getTriplet130;
				};
				totalPoints = totalPoints + 2;
				this.allAge();
			}

			// SBP between 140 - 159
			{(systolicBloodPressure > 139) && (systolicBloodPressure < 160)} {
				case
				{(rhythm == "straight")} {
					// Do the straight 6 note pattern
					drumPattern = drumP.getStraight140;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 6 note pattern
					drumPattern = drumP.getStraightOff140;
				}
				{(rhythm == "off")} {
					// Do the off 6 note pattern
					drumPattern = drumP.getOff140;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 6 note pattern
					drumPattern = drumP.getTriplet140;
				};
				totalPoints = totalPoints + 2;
				this.allAge();
			}

			// SBP more than or equal to 160
			{(systolicBloodPressure >= 160)} {
				case
				{(rhythm == "straight")} {
					// Do the straight 7+ note pattern
					drumPattern = drumP.getStraight160;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 7+ note patter
					drumPattern = drumP.getStraightOff160;
				}
				{(rhythm == "off")} {
					// Do the off 7+ note pattern
					drumPattern = drumP.getOff160;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 7+ note pattern
					drumPattern = drumP.getTriplet160;
				};
				totalPoints = totalPoints + 3;
				this.allAge();
			}

		}

		// Has no treatment
		{(treatment == false)} {
			reverb = 0;

			case
			// SBP below 120
			{(systolicBloodPressure < 120)} {
				case
				{(rhythm == "straight")} {
					// Do the straight 3 or less note pattern
					drumPattern = drumP.getStraight120;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 3 or less note pattern
					drumPattern = drumP.getStraightOff120;
				}
				{(rhythm == "off")} {
					// Do the off 3 or less note pattern
					drumPattern = drumP.getOff120;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 3 or less note pattern
					drumPattern = drumP.getTriplet120;
				};
				// No points
				this.allAge();
			}

			// SBP between 120 - 129
			{(systolicBloodPressure > 119) && (systolicBloodPressure < 130)} {
				case
				{(rhythm == "straight")} {
					// Do the straight 4 note pattern
					drumPattern = drumP.getStraight129;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 4 note pattern
					drumPattern = drumP.getStraightOff129;
				}
				{(rhythm == "off")} {
					// Do the off 4 note pattern
					drumPattern = drumP.getOff129;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 4 note pattern
					drumPattern = drumP.getTriplet129;
				};
				// No points
				this.allAge();
			}

			// SBP between 130-139
			{(systolicBloodPressure > 129) && (systolicBloodPressure < 140)} {
				case
				{(rhythm == "straight")} {
					// Do the straight 5 note pattern
					drumPattern = drumP.getStraight130;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 5 note pattern
					drumPattern = drumP.getStraightOff130;
				}
				{(rhythm == "off")} {
					// Do the off 5 note pattern
					drumPattern = drumP.getOff130;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 5 note pattern
					drumPattern = drumP.getTriplet130;
				};
				totalPoints = totalPoints + 1;
				this.allAge();
			}

			// SBP between 140 - 159
			{(systolicBloodPressure > 139) && (systolicBloodPressure < 160)} {
				case
				{(rhythm == "straight")} {
					// Do the straight 6 note pattern
					drumPattern = drumP.getStraight140;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 6 note pattern
					drumPattern = drumP.getStraightOff140;
				}
				{(rhythm == "off")} {
					// Do the off 6 note pattern
					drumPattern = drumP.getOff140;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 6 note pattern
					drumPattern = drumP.getTriplet140;
				};
				totalPoints = totalPoints + 1;
				this.allAge();
			}

			// SBP more than or equal to 160
			{(systolicBloodPressure >= 160)} {
				case
				{(rhythm == "straight")} {
					// Do the straight 7+ note pattern
					drumPattern = drumP.getStraight160;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 7+ note patter
					drumPattern = drumP.getStraightOff160;
				}
				{(rhythm == "off")} {
					// Do the off 7+ note pattern
					drumPattern = drumP.getOff160;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 7+ note pattern
					drumPattern = drumP.getTriplet160;
				};
				totalPoints = totalPoints + 2;
				this.allAge();
			}

		}
	}

	hdlTest {

		case
		// Hdl more equal to 60
		{(hdlCholesterol >= 60)} {
			rhythm = "straight";
			totalPoints = totalPoints -1;
			this.treatmentTest();
		}

		// Hdl between 50 - 59
		{(hdlCholesterol > 49) && (hdlCholesterol < 60)} {
			rhythm = "straightOff";
			// No points
			this.treatmentTest();
		}

		// Hdl between 40-49
		{(hdlCholesterol > 39) && (hdlCholesterol < 50)} {
			rhythm = "off";
			totalPoints = totalPoints +1;
			this.treatmentTest();
		}

		// Hdl below 40
		{(hdlCholesterol < 40)} {
			rhythm = "triplet";
			totalPoints = totalPoints +2;
			this.treatmentTest();
		}

	}

	// Risk level for males
	riskM {
		case
		{(totalPoints < 0)} {
			risk = "You have less than 1% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 0).or(totalPoints == 1).or(totalPoints == 2).or(totalPoints == 3).or(totalPoints == 4)} {
			risk = "You have a 1% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 5).or(totalPoints == 6)} {
			risk = "You have a 2% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 7)} {risk = "You have a 3% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 8)} {risk = "You have a 4% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 9)} {risk = "You have a 5% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 10)} {risk = "You have a 6% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 11)} {risk = "You have a 8% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 12)} {risk = "You have a 10% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 13)} {risk = "You have a 12% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 14)} {risk = "You have a 16% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 15)} {risk = "You have a 20% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 16)} {risk = "You have a 25% chance of having a heart attack in the next 10 years"}
		{(totalPoints >= 17)} {risk = "You have a 30% chance or higher of having a heart attack in the next 10 years"}

	}

	/*
	Methods for the female
	*/

	// Age between 20-39
	age2039F {
		synth = "solo1J";
		case
		// Is a smoker
		{(smoker == true)} {
			case
			{(rhythm == "straight")} {
				// Do the straight 7+ note pattern
				synthPattern = synthP.getStraightMinorSolo;
			}
			{(rhythm == "straightOff")} {
				// Do the straightOff 7+ note patter
				synthPattern = synthP.getStraightOffMinorSolo;
			}
			{(rhythm == "off")} {
				// Do the off 7+ note pattern
				synthPattern = synthP.getOffMinorSolo;
			}
			{(rhythm == "triplet")} {
				// Do the triplet 7+ note pattern
				synthPattern = synthP.getTripletMinorSolo;
			};
			//distortion = 0.5;
			totalPoints = totalPoints +9;
			case
			// Aged between 20 - 34
			{(age > 19) && (age < 35)} {
				osc = 0;
				totalPoints = totalPoints -7;
			}
			// Aged between 35 - 39
			{(age > 34) && (age < 40)} {
				osc = 1;
				totalPoints = totalPoints -3;
			}
		}
		// Is a non-smoker
		{(smoker == false)} {
			case
			{(rhythm == "straight")} {
				// Do the straight 7+ note pattern
				synthPattern = synthP.getStraightMajorSolo;
			}
			{(rhythm == "straightOff")} {
				// Do the straightOff 7+ note patter
				synthPattern = synthP.getStraightOffMajorSolo;
			}
			{(rhythm == "off")} {
				// Do the off 7+ note pattern
				synthPattern = synthP.getOffMajorSolo;
			}
			{(rhythm == "triplet")} {
				// Do the triplet 7+ note pattern
				synthPattern = synthP.getTripletMajorSolo;
			};
			distortion = 0;
			// No points
			case
			// Aged between 20 - 34
			{(age > 19) && (age < 35)} {
				osc = 0;
				totalPoints = totalPoints -7;
			}
			// Aged between 35 - 39
			{(age > 34) && (age < 40)} {
				osc = 1;
				totalPoints = totalPoints -3;
			}
		}
	}

	// Age between 40-49
	age4049F {
		case
		// Is a smoker
		{(smoker == true)} {
			//distortion = 0.5;
			totalPoints = totalPoints +7;
			case
			// Aged between 40 - 44
			{(age > 39) && (age < 45)} {
				synth = "solo1J";
				case
				{(rhythm == "straight")} {
					// Do the straight 7+ note pattern
					synthPattern = synthP.getStraightMinorSolo;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 7+ note patter
					synthPattern = synthP.getStraightOffMinorSolo;
				}
				{(rhythm == "off")} {
					// Do the off 7+ note pattern
					synthPattern = synthP.getOffMinorSolo;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 7+ note pattern
					synthPattern = synthP.getTripletMinorSolo;
				};
				osc = 2;
				// No points
			}
			// Aged between 45 - 49
			{(age > 44) && (age < 50)} {
				synth = "chrd1J";
				case
				{(rhythm == "straight")} {
					// Do the straight 7+ note pattern
					synthPattern = synthP.getStraightMinorChord;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 7+ note patter
					synthPattern = synthP.getStraightOffMinorChord;
				}
				{(rhythm == "off")} {
					// Do the off 7+ note pattern
					synthPattern = synthP.getOffMinorChord;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 7+ note pattern
					synthPattern = synthP.getTripletMinorChord;
				};
				osc = 0;
				totalPoints = totalPoints +3;
			}
		}
		// Is a non-smoker
		{(smoker == false)} {
			distortion = 0;
			// No points
			case
			// Aged between 40 - 44
			{(age > 39) && (age < 45)} {
				synth = "solo1J";
				case
				{(rhythm == "straight")} {
					// Do the straight 7+ note pattern
					synthPattern = synthP.getStraightMajorSolo;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 7+ note patter
					synthPattern = synthP.getStraightOffMajorSolo;
				}
				{(rhythm == "off")} {
					// Do the off 7+ note pattern
					synthPattern = synthP.getOffMajorSolo;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 7+ note pattern
					synthPattern = synthP.getTripletMajorSolo;
				};
				osc = 2;
				// No points
			}
			// Aged between 45 - 49
			{(age > 44) && (age < 50)} {
				synth = "chrd1J";
				case
				{(rhythm == "straight")} {
					// Do the straight 7+ note pattern
					synthPattern = synthP.getStraightMajorChord;
				}
				{(rhythm == "straightOff")} {
					// Do the straightOff 7+ note patter
					synthPattern = synthP.getStraightOffMajorChord;
				}
				{(rhythm == "off")} {
					// Do the off 7+ note pattern
					synthPattern = synthP.getOffMajorChord;
				}
				{(rhythm == "triplet")} {
					// Do the triplet 7+ note pattern
					synthPattern = synthP.getTripletMajorChord;
				};
				osc = 0;
				totalPoints = totalPoints +3;
			}
		}
	}

	// Age between 50-59
	age5059F {
		synth = "chrd1J";
		case
		// Is a smoker
		{(smoker == true)} {
			case
			{(rhythm == "straight")} {
				// Do the straight 7+ note pattern
				synthPattern = synthP.getStraightMinorChord;
			}
			{(rhythm == "straightOff")} {
				// Do the straightOff 7+ note patter
				synthPattern = synthP.getStraightOffMinorChord;
			}
			{(rhythm == "off")} {
				// Do the off 7+ note pattern
				synthPattern = synthP.getOffMinorChord;
			}
			{(rhythm == "triplet")} {
				// Do the triplet 7+ note pattern
				synthPattern = synthP.getTripletMinorChord;
			};
			//distortion = 0.5;
			totalPoints = totalPoints +4;
			case
			// Aged between 50-54
			{(age > 49) && (age < 55)} {
				osc = 1;
				totalPoints = totalPoints +6;
			}
			// Aged between 55-59
			{(age > 54) && (age < 60)} {
				osc = 2;
				totalPoints = totalPoints +8;
			}
		}
		// Is a non-smoker
		{(smoker == false)} {
			case
			{(rhythm == "straight")} {
				// Do the straight 7+ note pattern
				synthPattern = synthP.getStraightMajorChord;
			}
			{(rhythm == "straightOff")} {
				// Do the straightOff 7+ note patter
				synthPattern = synthP.getStraightOffMajorChord;
			}
			{(rhythm == "off")} {
				// Do the off 7+ note pattern
				synthPattern = synthP.getOffMajorChord;
			}
			{(rhythm == "triplet")} {
				// Do the triplet 7+ note pattern
				synthPattern = synthP.getTripletMajorChord;
			};
			distortion = 0;
			// No points
			case
			// Aged between 50-54
			{(age > 49) && (age < 55)} {
				osc = 1;
				totalPoints = totalPoints +6;
			}
			// Aged between 55-59
			{(age > 54) && (age < 60)} {
				osc = 2;
				totalPoints = totalPoints +8;
			}
		}
	}

	// Age between 60-69
	age6069F {
		case
		// Is a smoker
		{(smoker == true)} {
			case
			{(rhythm == "straight")} {
				// Do the straight 7+ note pattern
				synthPattern = synthP.getStraightMinorChord;
			}
			{(rhythm == "straightOff")} {
				// Do the straightOff 7+ note patter
				synthPattern = synthP.getStraightOffMinorChord;
			}
			{(rhythm == "off")} {
				// Do the off 7+ note pattern
				synthPattern = synthP.getOffMinorChord;
			}
			{(rhythm == "triplet")} {
				// Do the triplet 7+ note pattern
				synthPattern = synthP.getTripletMinorChord;
			};
			//distortion = 0.5;
			totalPoints = totalPoints +2;
			case
			// Aged between 60-64
			{(age > 59) && (age < 65)} {
				synth = "chrd1J";
				osc = 3;
				totalPoints = totalPoints +10;
			}
			// Aged between 65-69
			{(age > 64) && (age < 70)} {
				synth = "chrd2J";
				osc = 0;
				totalPoints = totalPoints +12;
			}
		}
		// Is a non-smoker
		{(smoker == false)} {
			case
			{(rhythm == "straight")} {
				// Do the straight 7+ note pattern
				synthPattern = synthP.getStraightMajorChord;
			}
			{(rhythm == "straightOff")} {
				// Do the straightOff 7+ note patter
				synthPattern = synthP.getStraightOffMajorChord;
			}
			{(rhythm == "off")} {
				// Do the off 7+ note pattern
				synthPattern = synthP.getOffMajorChord;
			}
			{(rhythm == "triplet")} {
				// Do the triplet 7+ note pattern
				synthPattern = synthP.getTripletMajorChord;
			};
			distortion = 0;
			// No points
			case
			// Aged between 60-64
			{(age > 59) && (age < 65)} {
				synth = "chrd1J";
				osc = 3;
				totalPoints = totalPoints +10;
			}
			// Aged between 65-69
			{(age > 64) && (age < 70)} {
				synth = "chrd2J";
				osc = 0;
				totalPoints = totalPoints +12;
			}
		}
	}

	// Age between 70-79
	age7079F {
		synth = "chrd2J";
		case
		// Is a smoker
		{(smoker == true)} {
			case
			{(rhythm == "straight")} {
				// Do the straight 7+ note pattern
				synthPattern = synthP.getStraightMinorChord;
			}
			{(rhythm == "straightOff")} {
				// Do the straightOff 7+ note patter
				synthPattern = synthP.getStraightOffMinorChord;
			}
			{(rhythm == "off")} {
				// Do the off 7+ note pattern
				synthPattern = synthP.getOffMinorChord;
			}
			{(rhythm == "triplet")} {
				// Do the triplet 7+ note pattern
				synthPattern = synthP.getTripletMinorChord;
			};
			//distortion = 0.5;
			totalPoints = totalPoints +1;
			case
			// Aged between 70-74
			{(age > 69) && (age < 75)} {
				osc = 1;
				totalPoints = totalPoints +14;
			}
			// Aged between 75-79
			{(age > 74) && (age < 80)} {
				osc = 2;
				totalPoints = totalPoints +16;
			}
		}
		// Is a non-smoker
		{(smoker == false)} {
			case
			{(rhythm == "straight")} {
				// Do the straight 7+ note pattern
				synthPattern = synthP.getStraightMajorChord;
			}
			{(rhythm == "straightOff")} {
				// Do the straightOff 7+ note patter
				synthPattern = synthP.getStraightOffMajorChord;
			}
			{(rhythm == "off")} {
				// Do the off 7+ note pattern
				synthPattern = synthP.getOffMajorChord;
			}
			{(rhythm == "triplet")} {
				// Do the triplet 7+ note pattern
				synthPattern = synthP.getTripletMajorChord;
			};
			distortion = 0;
			// No points
			case
			// Aged between 70-74
			{(age > 69) && (age < 75)} {
				osc = 1;
				totalPoints = totalPoints +14;
			}
			// Aged between 75-79
			{(age > 74) && (age < 80)} {
				osc = 2;
				totalPoints = totalPoints +16;
			}
		}
	}

	// Treatment true and sbp < 120
	allAgeF {
		case
		// Aged between 20 - 39
		{(age > 19) && (age < 40)} {

			case
			// Tc below 160
			{(totalCholesterol < 160)} {
				delay = 0;
				// No points
				this.age2039F();
			}
			// Tc between 160 - 199
			{(totalCholesterol > 159) && (totalCholesterol < 200) } {
				delay = 0.2;
				totalPoints = totalPoints +4;
				this.age2039F();
			}
			// Tc between 200 - 239
			{(totalCholesterol > 199) && (totalCholesterol < 240) } {
				delay = 0.4;
				totalPoints = totalPoints +8;
				this.age2039F();
			}
			// Tc between 240 - 279
			{(totalCholesterol > 239) && (totalCholesterol < 280) } {
				delay = 0.6;
				totalPoints = totalPoints +11;
				this.age2039F();
			}
			// Tc is above or equal to 280
			{(totalCholesterol >= 280)} {
				delay = 0.8;
				totalPoints = totalPoints +13;
				this.age2039F();
			}
		}

		// Aged between 40 - 49
		{(age > 39) && (age < 50)} {

			case
			// Tc below 160
			{(totalCholesterol < 160)} {
				delay = 0;
				// No points
				this.age4049F();
			}
			// Tc between 160 - 199
			{(totalCholesterol > 159) && (totalCholesterol < 200) } {
				delay = 0.2;
				totalPoints = totalPoints +3;
				this.age4049F();
			}
			// Tc between 200 - 239
			{(totalCholesterol > 199) && (totalCholesterol < 240) } {
				delay = 0.4;
				totalPoints = totalPoints +6;
				this.age4049F();
			}
			// Tc between 240 - 279
			{(totalCholesterol > 239) && (totalCholesterol < 280) } {
				delay = 0.6;
				totalPoints = totalPoints +8;
				this.age4049F();
			}
			// Tc is above or equal to 280
			{(totalCholesterol >= 280)} {
				delay = 0.8;
				totalPoints = totalPoints +10;
				this.age4049F();
			}
		}

		// Aged between 50 - 59
		{(age > 49) && (age < 60)} {

			case
			// Tc below 160
			{(totalCholesterol < 160)} {
				delay = 0;
				// No points
				this.age5059F();
			}
			// Tc between 160 - 199
			{(totalCholesterol > 159) && (totalCholesterol < 200) } {
				delay = 0.2;
				totalPoints = totalPoints +2;
				this.age5059F();
			}
			// Tc between 200 - 239
			{(totalCholesterol > 199) && (totalCholesterol < 240) } {
				delay = 0.4;
				totalPoints = totalPoints +4;
				this.age5059F();
			}
			// Tc between 240 - 279
			{(totalCholesterol > 239) && (totalCholesterol < 280) } {
				delay = 0.6;
				totalPoints = totalPoints +5;
				this.age5059F();
			}
			// Tc is above or equal to 280
			{(totalCholesterol >= 280)} {
				delay = 0.8;
				totalPoints = totalPoints +7;
				this.age5059F();
			}
		}

		// Aged between 60-69
		{(age > 59) && (age < 70)} {

			case
			// Tc below 160
			{(totalCholesterol < 160)} {
				delay = 0;
				// No points
				this.age6069F();
			}
			// Tc between 160 - 199
			{(totalCholesterol > 159) && (totalCholesterol < 200) } {
				delay = 0.2;
				totalPoints = totalPoints +1;
				this.age6069F();
			}
			// Tc between 200 - 239
			{(totalCholesterol > 199) && (totalCholesterol < 240) } {
				delay = 0.4;
				totalPoints = totalPoints +2;
				this.age6069F();
			}
			// Tc between 240 - 279
			{(totalCholesterol > 239) && (totalCholesterol < 280) } {
				delay = 0.6;
				totalPoints = totalPoints +3;
				this.age6069F();
			}
			// Tc is above or equal to 280
			{(totalCholesterol >= 280)} {
				delay = 0.8;
				totalPoints = totalPoints +4;
				this.age6069F();
			}
		}

		// Aged between 70-79
		{(age > 69) && (age < 80)} {

			case
			// Tc below 160
			{(totalCholesterol < 160)} {
				delay = 0;
				// No points
				this.age7079F();
			}
			// Tc between 160 - 199
			{(totalCholesterol > 159) && (totalCholesterol < 200) } {
				delay = 0.2;
				totalPoints = totalPoints +1;
				this.age7079F();
			}
			// Tc between 200 - 239
			{(totalCholesterol > 199) && (totalCholesterol < 240) } {
				delay = 0.4;
				totalPoints = totalPoints +1;
				this.age7079F();
			}
			// Tc between 240 - 279
			{(totalCholesterol > 239) && (totalCholesterol < 280) } {
				delay = 0.6;
				totalPoints = totalPoints +2;
				this.age7079F();
			}
			// Tc is above or equal to 280
			{(totalCholesterol >= 280)} {
				delay = 0.8;
				totalPoints = totalPoints +2;
				this.age7079F();
			}
		}
	}

	// Treatment female
	treatmentTestF {
		case
		// Has treatment
		{(treatment == true)} {
			reverb = 0.5;

			case
			// SBP below 120
			{(systolicBloodPressure < 120)} {
				lforate = 1;
				// No points
				this.allAgeF();
			}

			// SBP between 120 - 129
			{(systolicBloodPressure > 119) && (systolicBloodPressure < 130)} {
				lforate = 4;
				totalPoints = totalPoints + 3;
				this.allAgeF();
			}

			// SBP between 130-139
			{(systolicBloodPressure > 129) && (systolicBloodPressure < 140)} {
				lforate = 7;
				totalPoints = totalPoints + 4;
				this.allAgeF();
			}

			// SBP between 140 - 159
			{(systolicBloodPressure > 139) && (systolicBloodPressure < 160)} {
				lforate = 10;
				totalPoints = totalPoints + 5;
				this.allAgeF();
			}

			// SBP more than or equal to 160
			{(systolicBloodPressure >= 160)} {
				lforate = 13;
				totalPoints = totalPoints + 6;
				this.allAgeF();
			}

		}

		// Has no treatment
		{(treatment == false)} {
			reverb = 0;

			case
			// SBP below 120
			{(systolicBloodPressure < 120)} {
				lforate = 1;
				// No points
				this.allAgeF();
			}

			// SBP between 120 - 129
			{(systolicBloodPressure > 119) && (systolicBloodPressure < 130)} {
				lforate = 4;
				totalPoints = totalPoints + 1;
				this.allAgeF();
			}

			// SBP between 130-139
			{(systolicBloodPressure > 129) && (systolicBloodPressure < 140)} {
				lforate = 7;
				totalPoints = totalPoints + 2;
				this.allAgeF();
			}

			// SBP between 140 - 159
			{(systolicBloodPressure > 139) && (systolicBloodPressure < 160)} {
				lforate = 10;
				totalPoints = totalPoints + 3;
				this.allAgeF();
			}

			// SBP more than or equal to 160
			{(systolicBloodPressure >= 160)} {
				lforate = 13;
				totalPoints = totalPoints + 4;
				this.allAgeF();
			}

		}
	}

	// Hdl test female
	hdlTestF {

		case
		// Hdl more equal to 60
		{(hdlCholesterol >= 60)} {
			rhythm = "straight";
			totalPoints = totalPoints -1;
			this.treatmentTestF();
		}

		// Hdl between 50 - 59
		{(hdlCholesterol > 49) && (hdlCholesterol < 60)} {
			rhythm = "straightOff";
			// No points
			this.treatmentTestF();
		}

		// Hdl between 40-49
		{(hdlCholesterol > 39) && (hdlCholesterol < 50)} {
			rhythm = "off";
			totalPoints = totalPoints +1;
			this.treatmentTestF();
		}

		// Hdl below 40
		{(hdlCholesterol < 40)} {
			rhythm = "triplet";
			totalPoints = totalPoints +2;
			this.treatmentTestF();
		}

	}

	// Risk level for females
	riskF {
		case
		{(totalPoints < 9)} {
			risk = "You have less than 1% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 9).or(totalPoints == 10).or(totalPoints == 11).or(totalPoints == 12)} {
			risk = "You have a 1% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 13).or(totalPoints == 14)} {
			risk = "You have a 2% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 15)} {risk = "You have a 3% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 16)} {risk = "You have a 4% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 17)} {risk = "You have a 5% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 18)} {risk = "You have a 6% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 19)} {risk = "You have a 8% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 20)} {risk = "You have a 11% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 21)} {risk = "You have a 14% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 22)} {risk = "You have a 17% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 23)} {risk = "You have a 22% chance of having a heart attack in the next 10 years"}
		{(totalPoints == 24)} {risk = "You have a 27% chance of having a heart attack in the next 10 years"}
		{(totalPoints >= 25)} {risk = "You have a 30% chance or higher of having a heart attack in the next 10 years"}

	}

	// Test for either gender and do all tests:
	genderTest {

		case
		// Is male
		{(gender == "male")} {
			this.hdlTest();
			this.riskM();
		}

		{(gender == "female")} {
			this.hdlTestF();
			this.riskF();
		}
	}

	// Calculate overall risk and the synth for the human!
	calculateRisk {
		// Reset total Points to 0;
		synthP.setPatterns(age);
		totalPoints = 0;
		this.genderTest();
	}

}









