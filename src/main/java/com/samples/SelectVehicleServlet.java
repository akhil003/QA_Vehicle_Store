package com.samples;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.model.VehicleType;

@WebServlet(
		name = "selectvehicleservlet",
		urlPatterns = "/SelectVehicle"
		)
public class SelectVehicleServlet extends HttpServlet {     

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String vehicleType = req.getParameter("Type");



		VehicleService vehicleService = new VehicleService();
		VehicleType v = VehicleType.valueOf(vehicleType);

		List vehicleBrands = vehicleService.getAvailableBrands(v);

		req.setAttribute("brands", vehicleBrands);
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		view.forward(req, resp);


		
	}




}



