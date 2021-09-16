def mifflinEq(ageValue, gender, heightCMValue, weightKGValue):
    age = int(ageValue)
    sex = str(gender)
    heightCM = int(heightCMValue)
    weightKG = int(weightKGValue)

    if sex == "Male":
        bmr = ((10 * weightKG) + (6.25 * heightCM) - (5 * age) + 5)
    elif sex == "Female":
        bmr = ((10 * weightKG) + (6.25 * heightCM) - (5 * age) - 161)
    else:
        return "Error"
        quit()

    #returns a floating point number that is a rounded version of the specified number
    bmr = round(bmr)
    return(bmr)


def harrisEq(ageValue, gender, heightCMValue, weightKGValue):
    age = int(ageValue)
    sex = str(gender)
    heightCM = int(heightCMValue)
    weightKG = int(weightKGValue)

    if sex == "Male":
        bmr = ((13.397 * weightKG) + (4.799 * heightCM) - (5.677 * age) + 88.362)
    elif sex == "Female":
        bmr = ((9.247 * weightKG) + (3.098 * heightCM) - (4.330 * age) + 447.593)
    else:
        return "Error"
        quit()

    #returns a floating point number that is a rounded version of the specified number
    bmr = round(bmr)
    return(bmr)
