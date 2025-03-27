1. In what ways getHostName() differs from getCannonicalHostName()?

- 1.getHostName()
  - Retrieves the hostname based on the current system's settings or a simple DNS lookup.
  - If a hostname is not available, it may return the IP address instead.
  - Does not perform a full DNS resolution.
- 2.getCanonicalHostName()
  - Performs a full DNS lookup to get the canonical (official) hostname.
  - Returns the Fully Qualified Domain Name (FQDN) if available.
  - If no DNS resolution is possible, it may return the same as getHostName() or just the IP.
