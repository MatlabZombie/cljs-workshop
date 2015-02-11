(ns cljsworkshop.geocoder
	(require 	[compojure.core :refer :all]
            	[compojure.response :refer [render]]
            	[clojure.java.io :as io]
				[geocoder.google :as g-geocoder]))

(defn geocode
  [req]
  (render (io/resource "result.html") req))

