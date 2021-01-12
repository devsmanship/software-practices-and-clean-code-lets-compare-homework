class car_Service1 {	
	public List<Car> gettingTheCarsForUsers(User user) {
		List<Car> getListOfCars = new ArrayList<>();
		User userWhichIsLogged = UserSession.getInstance().getLoggedUser();
		if(userWhichIsLogged != null) {
			if(userWhichIsLogged.getId().equals(user.getId())) {
				if(!user.getStatus().getStatusCode().equals("5")) { // 5 status code means that user is active
					throw new Exception("User is not active");
				} else {
					getListOfCars.addAll(carRepository.findByUser(user));
				}
			} else {
				throw new Exception("User is not authorized for this action");
			}
			
		} else {
			throw new UserNotLoggedInException();
		}
		
		return getListOfCars;
	}
}