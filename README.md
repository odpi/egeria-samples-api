<!-- SPDX-License-Identifier: CC-BY-4.0 -->
<!-- Copyright Contributors to the ODPi Egeria project. -->

# Egeria API Samples (egeria-samples-api)

This repository is a collection of samples that show how to use Egeria's metadata management and governance APIs
to set up and run a sustainability initiative at the fictitious company
[Coco Pharmaceuticals](https://egeria-project.org/practices/coco-pharmaceuticals/).

Sustainability reporting is increasingly required by governments and financial institutions. 
Companies are encouraged to set targets to reduce their emissions 
and to report on their progress towards these targets. 
The [Greenhouse Gas Protocol](https://ghgprotocol.org/) defines the foundational methods for this process.

Improving the sustainability of an organization is a continuous process of:

* reviewing its operations
* measuring the impact of these operations
* aggregating these impacts across locations and divisions of an organization
* reviewing, certifying and reporting on sustainability
* setting targets to improve sustainability
* taking action to achieve these targets
* measuring the change
* *repeat*

All parts of the organization need to be involved.  Investment in automation around this process is also important
to ensure ongoing improvements to data collection and remediations that improve the sustainability of their operations becomes embedded in the business, not something they
focus on from time-to-time.

The samples are divided into the following groups:

* [Extending the governance program](#extending-the-governance-program) to include a sustainability focus.
* [Creating an inventory](#creating-the-operations-inventory) of Coco Pharmaceuticals operations.
* [Finding and cataloguing the data](#finding-and-cataloguing-data) that describes the impact of their operations.
* [Building the sustainability dashboard](#building-the-sustainability-dashboard) to continuously monitor the sustainability status of Coco Pharmaceuticals.
* Validating and publishing sustainability report
* [Assessing and improving IT operations](#assessing-and-improving-it-systems).
* [Sustainability Webpages](#sustainability-webpages)

## Understanding Sustainability Reporting

The GHG Protocol defines strategies, processes and techniques for collecting and calculating carbon emissions. Three classes of emissions are defined:

* Scope 1 - Direct Emissions from Operations
* Scope 2 - Indirect Emissions from Utility Consumption
* Scope 3 - Other indirect emissions

Most reporting is focused on Scope 1 and Scope 2; for Scope 3 there is often a limited focus on business travel.

Calculations for each kind of emission is specified in the GHG Protocol. Reference data supporting these calculations varies over time, location, and sometimes industry - so we need to perform the calculations on a location by location basis and then aggregate this information. This is also useful since we can more easily compare locations and identify the different challenges they face. As we perform these calculations it is important that we record how the results are computed, including which reference data were used..

## More information on the samples

### Extending the governance program

Coco Pharmaceuticals has an existing governance program that helps them manage their operations.
This governance program is divided into multiple governance domains that each focus on a specific aspect of their
operations.  For example, they have a domain for data governance, a domain for security and a domain for privacy.

The samples for extending the governance program show how to add a new governance domain for sustainability.

[Go to code ...](governance-program)

### Creating the operations inventory

Coco Pharmaceuticals need to report on all aspects of their operation.  
To ensure they have not missed anything, and to identify where improvements can be made,
they need lists of their locations and the equipment and activity at each location.  This is called the operations
inventory and provides a context for the data they collect.  

For example, they have utility bills for each of the sites they operate.  
The operations inventory will tell them what type of activities - such as office work, 
manufacturing, research, ...) are occurring at each site, what types of equipment runs there and
which part of the business is responsible for each aspect. With the inventory they can apportion the power or
water use to these aspects and then review the data from different perspectives:

* Business area (and hence associated revenue)
* Types of activity
* Types of facilities (such as offices, data centres, )
* Types of equipment (such as IT systems, refrigeration units, robots, vehicles, ...)

This way they can pick the most important things to change first.

The samples for building the operations inventory show how to define new types of equipment, catalog the
locations, facilities, equipments and activities at each location and issue queries to show different 
parts of the inventory.

[Go to code ...](operations-inventory)

### Finding and cataloguing data

Understanding the impact of operations takes more than utility bills.  It is important to understand
impact of travel, loss of coolants (such as CFCs), fuel for manufacturing equipment, ...

Data about these impacts need to be catalogued so the teams analysing the data and making choices on actions
to take can find the data. 

The catalog entries for this data need to link to the appropriate parts of the operations inventory to provide
context to the data.  Different locations will often have different sources of data. Often data from different sources uses different units, terminology and reference values.
The process of cataloguing data must capture this type of detail to make it consumable by the analysis processes. 

The samples for cataloguing data show how to catalog data and link/tag it, so it is ready for analysis.

[Go to code ...](cataloguing-data)

### Building the sustainability dashboard

In order to keep sustainability in people's minds (and to provide data to the different stakeholders),
Coco Pharmaceuticals want to have a set of dashboards and reports that shows their current status and how it is changing
(better or worse) over time.

Data pipelines take the raw data they have, and normalize the data so that the CO2 equivalent emissions can be calculated using standard techniques. transform and combine it into a sustainability database that supplies
data to these new dashboards and reports.

The samples for the sustainability dashboard includes building the data pipelines, cataloguing them
and recording lineage to show the origin of the data in the reports/dashboards. Lineage is especially important in certifying the accuracy of reported metrics.

[Go to code ...](sustainability-dashboard)

### Assessing and improving IT systems

IT systems (computers) use a lot of electricity.

Coco Pharmaceuticals use many IT systems to run their business, automate their factories, depots, and labs.
The research work in particular requires powerful machines running calculations and other analytics to identify,
develop and validate their treatments.

The number of IT systems continues to grow since new systems are often added and old systems are rarely removed.
One surefire way to reduce the impact of their operations is to remove obsolete IT systems and streamline/consolidate their
processing onto a smaller number of more power efficient computers.

[Go to code ...](it-systems)

## Sustainability webpages

Different personas need different information to help them understand the sustainability of their area of responsibility,
and the impact of the changes they are making on the situation.  The sustainability webpages show different views of
the Egeria information targeted for different personas.

[Go to code ...](sustainability-webpages)


----
License: [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/),
Copyright Contributors to the ODPi Egeria project.
