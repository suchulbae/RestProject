/* globals Chart:false, feather:false */

(function () {
  'use strict'
  

	const person = document.querySelector("#myChart");

  

  feather.replace({ 'aria-hidden': 'true' })

  // Graphs
  var ctx = document.getElementById('myChart')
  // eslint-disable-next-line no-unused-vars
  var myChart = new Chart(ctx, {
    type: 'line',
   
    data: {
      labels: [
        '6일전',
        '5일전',
        '4일전',
        '3일전',
        '2일전',
        '어제',
        '오늘'
      ],

      datasets: [{
        data: [
	person.dataset.user7,
		 person.dataset.user6,
		 person.dataset.user5,
			 person.dataset.user4,
		 person.dataset.user3,
		 person.dataset.user2,
		  person.dataset.user1,
	
		
          
     
   
          
     
        ],
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })
})()
