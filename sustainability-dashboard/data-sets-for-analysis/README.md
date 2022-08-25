<!-- SPDX-License-Identifier: CC-BY-4.0 -->
<!-- Copyright Contributors to the Egeria project. -->

# List the data sets available for sustainability analysis

The results the emissions calculations are stored in the **coco_sus** database - a small data mart used to collect and analyze the sustainability results within Coco Pharmaceuticals over many years. Within coco_sus are a number of tables and views that support the Sustainability Dashboard. Key relations include:

* **sites** - containing details about all of Coco Pharmaceuticals locations
* **ghg_emissions** - each kind of emissions produced by each site per year
* **scope_emissions** - a view that rolls up the emissions data from ghg_emissions per scope
* **summary_emissions** - a view that rolls up the enterprise emissions for each year, by scope



----
License: [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/), Copyright Contributors to the Egeria project.
