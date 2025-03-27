1. In what ways getHostName() differs from getCannonicalHostName()?

=> 1.getHostName()
_ Retrieves the hostname based on the current system's settings or a simple DNS lookup.
_ If a hostname is not available, it may return the IP address instead.
_ Does not perform a full DNS resolution.
2.getCanonicalHostName()
_ Performs a full DNS lookup to get the canonical (official) hostname.
_ Returns the Fully Qualified Domain Name (FQDN) if available.
_ If no DNS resolution is possible, it may return the same as getHostName() or just the IP.
