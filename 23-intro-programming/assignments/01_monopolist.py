def optimum_price():

	"""returns the ticket price which optimises cinema profit"""

	price = 0
	attendance = 0
	max_profit = 0
	temp_price = 0
	temp_attendance = 0

	while price >= 0 and attendance >= 0:
		attendance = 120 + (5-price) * 10 * 15
		cost = 180 + 0.04 * attendance
		revenue = price * attendance
		profit = revenue - cost

		if profit > max_profit:
			temp_price = price	
			max_profit = max(max_profit,profit)
			temp_attendance = attendance
	
		price += 0.1

	print (f"optimum price is {round(temp_price,2)}", f"optimum attendace is {round(temp_attendance,2)}",f"the max profit is {max_profit}")

	return round(temp_price,2)
